package com.pop.kids.tabfragmenttask.views.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat

@Parcelize
data class Show(
    val language: String?,
    val name: String?,
    val premiered: String?,
    val summary: String?,
    val image: Image?,
): Parcelable {
    fun getFormattedDate(): String {
        return premiered?.let {
            val format1 = SimpleDateFormat("yyyy-MM-dd")
            val format2 = SimpleDateFormat("dd-MMM-yy")
            val date = format1.parse(it)
            format2.format(date)
        } ?: ""
    }
}