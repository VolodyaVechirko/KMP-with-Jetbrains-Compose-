package koin

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ToastManager {
    private val sharedFlow = MutableSharedFlow<Toast>(1)

    val flow: SharedFlow<Toast> = sharedFlow.asSharedFlow()

    fun show(toast: Toast) {
        sharedFlow.tryEmit(toast)
    }

    fun <T : Any?> show(any: T) {
        show(Toast(any.toString()))
    }
}

data class Toast(
    val message: String
)