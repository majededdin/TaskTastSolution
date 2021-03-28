package majed.eddin.tasksolution.data.model.service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    var uri: String,
    var url: String,
    var id: Long,
    var asset_id: Long,
    var source: String,
    var published_date: String,
    var updated: String,
    var section: String,
    var subsection: String,
    var nytdsection: String,
    var adx_keywords: String,
    var column: String?,
    var byline: String,
    var type: String,
    var title: String,
    var abstract: String,
    var des_facet: ArrayList<String>,
    var org_facet: ArrayList<String>,
    var per_facet: ArrayList<String>,
    var geo_facet: ArrayList<String>,
    var media: ArrayList<Media>
) : Parcelable