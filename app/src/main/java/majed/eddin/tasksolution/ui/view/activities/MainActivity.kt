package majed.eddin.tasksolution.ui.view.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import majed.eddin.tasksolution.data.model.modified.ErrorHandler
import majed.eddin.tasksolution.data.model.service.Result
import majed.eddin.tasksolution.data.remote.ApiResponse
import majed.eddin.tasksolution.data.remote.ApiStatus
import majed.eddin.tasksolution.databinding.ActivityMainBinding
import majed.eddin.tasksolution.ui.base.BaseActivity
import majed.eddin.tasksolution.ui.view.adapters.ArticlesAdapter
import majed.eddin.tasksolution.ui.viewModel.ArticlesViewModel
import majed.eddin.tasksolution.utils.extentionUtils.toGone
import majed.eddin.tasksolution.utils.extentionUtils.toVisible

class MainActivity : BaseActivity<ArticlesViewModel>() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var restaurantsVM: ArticlesViewModel

    private lateinit var adapter: ArticlesAdapter
    private var apiResponse: ApiResponse<Result> = ApiResponse()


    override fun getViewModel(): Class<ArticlesViewModel> = ArticlesViewModel::class.java


    override fun viewModelInstance(viewModel: ArticlesViewModel?) {
        restaurantsVM = viewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewInit()
        updateView()

        restaurantsVM.articlesListResult.observe(this, this::restaurantsListResult)
    }


    override fun updateView() {
        apiResponse.listOfModel.clear()
        adapter.clear()

        restaurantsVM.getArticlesIndex()
    }


    private fun restaurantsListResult(apiResponse: ApiResponse<Result>) {
        handleApiResponse(apiResponse) { updateView() }
        if (apiResponse.apiStatus == ApiStatus.OnSuccess) {
            setResponseResult(apiResponse.listOfModel)
        }
    }


    private fun setResponseResult(list: ArrayList<Result>) {
        if (list.isNotEmpty()) {
            binding.layoutEmptyView.toGone()
            binding.recyclerArticles.toVisible()
            adapter.addAll(list)
        } else {
            binding.recyclerArticles.toGone()
            binding.layoutEmptyView.toVisible()
            apiResponse.listOfModel.clear()
            adapter.clear()
        }
    }


    override fun setErrorHandler(handler: ErrorHandler) {
    }


    override fun viewInit() {
        adapter = ArticlesAdapter(this)
        binding.recyclerArticles.adapter = adapter
        binding.recyclerArticles.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

}