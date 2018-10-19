package mvvm.sample.foods.data.network

data class ApiError(
    val status: ApiStatus,
    val code: Int = -1,
    var message: String = ""
) {
    fun getErrorMessage(): String {
        if (message.isNullOrEmpty()) {
            message = when (status) {
                ApiStatus.EMPTY_RESPONSE -> "no data available in repository"
                ApiStatus.NO_CONNECTION -> "error in connecting to repository"
                ApiStatus.BAD_RESPONSE -> "error in getting response "
                ApiStatus.TIMEOUT -> " Time out  error"
                ApiStatus.NOT_DEFINED -> "an unexpected error"
            }
        }

        return message
    }

    enum class ApiStatus {
        /**
         * error in connecting to repository (Server or Database)
         */
        NO_CONNECTION,
        /**
         * error in getting response (Json Error, Server Error, etc)
         */
        BAD_RESPONSE,
        /**
         * Time out  error
         */
        TIMEOUT,
        /**
         * no data available in repository
         */
        EMPTY_RESPONSE,
        /**
         * an unexpected error
         */
        NOT_DEFINED;
    }

}