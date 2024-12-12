package org.example.music.player.data.base

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import org.example.music.player.domain.AppException
import org.example.music.player.domain.BackendException
import org.example.music.player.domain.ConnectionException
import org.example.music.player.domain.ParseBackendResponseException
import retrofit2.HttpException
import java.io.IOException

open class BaseRetrofitSource(
    retrofitConfig: RetrofitConfig
) {

    val retrofit = retrofitConfig.retrofit

    private val moshi: Moshi = retrofitConfig.moshi
    private val errorAdapter = moshi.adapter(ErrorResponseBody::class.java)

    suspend fun <T> wrapRetrofitExceptions(block: suspend () -> T): T {
        return try {
            block()
        } catch (e: AppException) {
            throw e
            // moshi
        } catch (e: JsonDataException) {
            throw ParseBackendResponseException(e)
        } catch (e: JsonEncodingException) {
            throw ParseBackendResponseException(e)
            // retrofit
        } catch (e: HttpException) {
            throw createBackendException(e)
            // mostly retrofit
        } catch (e: IOException) {
            throw ConnectionException(e)
        }
    }

    private fun createBackendException(e: HttpException): Throwable {
        return try {
            val errorBody: ErrorResponseBody = errorAdapter.fromJson(
                e.response()!!.errorBody()!!.string()
            )!!
            BackendException(e.code(), errorBody.error)
        } catch (e: Exception) {
            throw ParseBackendResponseException(e)
        }
    }

    class ErrorResponseBody(
        val error: String
    )
}