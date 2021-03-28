package majed.eddin.tasksolution.ui.view.adapters

import am.dateutils.DateTimeStyle
import am.dateutils.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import majed.eddin.tasksolution.data.model.service.Result
import majed.eddin.tasksolution.databinding.ItemArticleBinding
import majed.eddin.tasksolution.ui.base.BaseActivity
import majed.eddin.tasksolution.utils.imageUtils.RoundedImage

class ArticlesAdapter(private val context: BaseActivity<*>) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private var items: ArrayList<Result> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {

                if (media.isNotEmpty()) {
                    binding.imgArticle.loadImage(media[0].metadata[0].url, RoundedImage())
                }

                binding.txtTitle.text = title
                binding.txtDescription.text = abstract
                binding.txtType.text = section
                binding.txtDate.text =
                    getArticleDate(DateUtils(context, updated, "en"))

            }
        }

    }


    private fun getArticleDate(dateUtils: DateUtils): String {
        return if (dateUtils.isToday || dateUtils.isYesterday)
            dateUtils.timeAgo
        else
            dateUtils.setSpecificFormat(DateTimeStyle.DATE_SHORT_STANDARD)

    }


    fun addAll(items: List<Result>) {
        for (result in items) {
            add(result)
        }
    }


    private fun add(r: Result) {
        items.add(r)
        notifyItemInserted(items.size - 1)
    }


    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = items.size


    inner class ViewHolder(var binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)


}