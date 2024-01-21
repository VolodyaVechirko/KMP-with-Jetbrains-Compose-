package ui.postfull

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import data.MainRepository
import data.PhotoModel
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class PostFullViewModel(
    private val postId: String,
    private val repository: MainRepository
) : ViewModel() {
    val state: MutableState<ScreenState> = mutableStateOf(ScreenState.Loading)

    init {
        viewModelScope.launch {
            repository.getPhoto(postId)
                .onSuccess {
                    state.value = ScreenState.Success(it)
                }
                .onFailure {
                    state.value = ScreenState.Error(it.toString())
                }
        }
    }
}

sealed class ScreenState {
    data object Loading : ScreenState()
    data class Error(val message: String) : ScreenState()
    data class Success(val post: PhotoModel) : ScreenState()
}