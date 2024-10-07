package com.example.pokemontest.utils

import android.content.Context
import com.example.pokemontest.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException


data class Fault(
    val code: Int = 0,
    val type: String? = null,
    var message: String,
    var data: Any? = null,
) {
    companion object {
        const val TIMEOUT = 1001
        const val UNKNOWN = 999
        const val NO_CONNECTION = 9991
        const val SERVICE_ERROR = 8888
        fun faultException(error: Exception, context: Context): Fault {
            return when (error) {
                is TimeoutException, is SocketTimeoutException -> {
                    Fault(
                        TIMEOUT,
                        context.getString(R.string.timeout_error_prompt),
                        context.getString(R.string.time_out_error_message)
                    )
                }

                is ConnectException -> {
                    Fault(
                        NO_CONNECTION,
                        context.getString(R.string.no_connection),
                        context.getString(R.string.no_conexion_prompt)
                    )
                }

                is ServiceException -> {
                    val message = error.message ?: context.getString(R.string.error_service)
                    Fault(
                        SERVICE_ERROR,
                        message,
                        message
                    )
                }

                else -> {
                    Fault(
                        UNKNOWN,
                        error.message ?: context.getString(R.string.unknown_error_prompt),
                        context.getString(R.string.average_error_message)
                    )
                }
            }
        }
    }
}