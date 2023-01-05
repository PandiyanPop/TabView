package com.pop.kids.tabfragmenttask.views.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pop.kids.tabfragmenttask.R
import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModelItem
import com.pop.kids.tabfragmenttask.views.movies.viewmodels.SeriesViewModel
import com.pop.kids.tabfragmenttask.views.ui.adapter.SeriesListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesListFragment: Fragment() {
    val viewModel: SeriesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_series_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = SeriesListAdapter()
        recyclerView.adapter = adapter

        val selectedItem = MutableLiveData<SeriesResponseModelItem>()
        viewModel.getSuccessData().observe(requireActivity()) {
            adapter.updateList(it, selectedItem)
            println("Data receieved: $it")
        }

        selectedItem.observe(requireActivity()) {

            val fragment = SeriesDetailsFragment()
            fragment.arguments = Bundle().apply { putParcelable("ParcelKey", it) }
            parentFragmentManager.beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack("SeriesListFragment")
                .commit()
        }
        viewModel.getSeriesList()
    }
}