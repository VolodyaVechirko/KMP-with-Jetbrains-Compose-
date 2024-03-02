package koin

import data.ApiService
import data.MainRepository
import org.koin.dsl.module
import ui.home.MainViewModel
import ui.postfull.PostFullViewModel

val commonModule = module {
    single {
        ApiService()
    }
    single {
        MainRepository(apiService = get())
    }

    single {
        ToastManager()
    }

    // ViewModels

    factory {
        MainViewModel(repository = get())
    }

    factory { (postId: String) ->
        PostFullViewModel(
            postId = postId,
            repository = get(),
        )
    }
}

fun appModule() = listOf(commonModule)