package com.pop.kids.tabfragmenttask.views.movies.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pop.kids.tabfragmenttask.views.movies.domain.SeriesRepositoryInterface
import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val seriesRepo: SeriesRepositoryInterface
):  ViewModel() {

    private val successLiveData = MutableLiveData<SeriesResponseModel>()
    private val errorLiveData = MutableLiveData<String>()

    fun getSeriesList() {
        viewModelScope.launch {
            seriesRepo.getSeriesList().apply {
                if (isSuccessful) {
                    successLiveData.value = body()
                } else {
                    errorLiveData.value = "Something went wrong"
                }
            }
        }
    }

    fun getSuccessData() = successLiveData
    fun getFailureData() = errorLiveData
}