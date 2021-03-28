package majed.eddin.tasksolution.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import majed.eddin.tasksolution.data.model.service.Result
import majed.eddin.tasksolution.data.remote.ApiResponse
import majed.eddin.tasksolution.data.repository.ArticlesRepo

class ArticlesViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: ArticlesRepo = ArticlesRepo()

    private val articlesListResponse = MutableLiveData<ApiResponse<Result>>()

    val articlesListResult: LiveData<ApiResponse<Result>>
        get() = articlesListResponse


    fun getArticlesIndex() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getArticles()
                .collect { articlesListResponse.postValue(it) }
        }
    }

}