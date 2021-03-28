package majed.eddin.tasksolution.data.model.service

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    var type: String,
    var subtype: String,
    var caption: String,
    var copyright: String,
    var approved_for_syndication: Int,
    @SerializedName("media-metadata")
    var metadata: ArrayList<MediaMeta>,
    var lng: Double
) : Parcelable