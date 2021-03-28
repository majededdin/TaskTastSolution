package majed.eddin.tasksolution.data.model.service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMeta(
    var url: String,
    var format: String,
    var height: Int,
    var width: Int
) : Parcelable