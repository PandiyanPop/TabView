package com.pop.kids.tabfragmenttask.views.movies.domain

import com.pop.kids.tabfragmenttask.views.movies.api.SeriesApiService
import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModel
import retrofit2.Response
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val apiService: SeriesApiService
): SeriesRepositoryInterface {
    override suspend fun getSeriesList(): Response<SeriesResponseModel> {
        return apiService.getSeriesList()
    }
}