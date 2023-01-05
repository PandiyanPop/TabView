package com.pop.kids.tabfragmenttask.di

import com.pop.kids.tabfragmenttask.views.movies.api.SeriesApiService
import com.pop.kids.tabfragmenttask.views.movies.domain.SeriesRepositoryImpl
import com.pop.kids.tabfragmenttask.views.movies.domain.SeriesRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSeriesRepo(repo: SeriesRepositoryImpl): SeriesRepositoryInterface = repo

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.tvmaze.com/")
        .client(OkHttpClient())
        .build()

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): SeriesApiService = retrofit.create(SeriesApiService::class.java)
}