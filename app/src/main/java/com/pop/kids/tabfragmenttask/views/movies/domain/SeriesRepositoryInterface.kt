package com.pop.kids.tabfragmenttask.views.movies.domain

import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModel
import retrofit2.Response

interface SeriesRepositoryInterface {
    suspend fun getSeriesList(): Response<SeriesResponseModel>
}