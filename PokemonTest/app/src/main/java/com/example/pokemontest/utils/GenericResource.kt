package com.example.pokemontest.utils

data class NewResource<T>(
    val status: Status,
    val data: T?,
    val error: Fault?
) {
    companion object {
        fun <T> loading(data: T?): NewResource<T> {
            return NewResource(Status.LOADING, data, null)
        }

        fun <T> finish(data: T?): NewResource<T> {
            return NewResource(Status.FINISH, data, null)
        }

        fun <T> success(data: T?): NewResource<T> {
            return NewResource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Fault?, data: T?): NewResource<T> {
            return NewResource(Status.ERROR, data, error)
        }
    }
}

enum class Status {
    LOADING,
    FINISH,
    SUCCESS,
    ERROR
}
