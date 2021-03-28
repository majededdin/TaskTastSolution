package majed.eddin.tasksolution.data.remote

enum class ApiStatus {
    OnAuth,
    OnBackEndError,
    OnConnectException,
    OnError,
    OnFailure,
    OnHttpException,
    OnLoading,
    OnNotFound,
    OnSuccess,
    OnTimeoutException,
    OnUnknownHost
}