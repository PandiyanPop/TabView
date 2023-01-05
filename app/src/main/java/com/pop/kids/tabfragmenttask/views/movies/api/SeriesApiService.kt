package com.pop.kids.tabfragmenttask.views.movies.api

import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface SeriesApiService {
    @GET("search/shows/?q=friends")
    suspend fun getSeriesList(): Response<SeriesResponseModel>
}