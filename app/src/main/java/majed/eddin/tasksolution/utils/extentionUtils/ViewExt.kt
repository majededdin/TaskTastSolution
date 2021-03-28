package majed.eddin.tasksolution.utils.extentionUtils

import android.view.View


fun View.toVisible() = kotlin.run { this.visibility = View.VISIBLE }


fun View.toGone() = kotlin.run { this.visibility = View.GONE }
