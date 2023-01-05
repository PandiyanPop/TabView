package com.pop.kids.tabfragmenttask.views.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SeriesResponseModelItem(
    val score: Double,
    val show: Show?
): Parcelable