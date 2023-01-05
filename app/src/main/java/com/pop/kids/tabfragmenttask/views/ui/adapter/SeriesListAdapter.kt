package com.pop.kids.tabfragmenttask.views.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pop.kids.tabfragmenttask.R
import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModelItem

class SeriesListAdapter: RecyclerView.Adapter<SeriesListAdapter.ViewHolder>() {
    private var itemsList: List<SeriesResponseModelItem> = mutableListOf()
    private var selectedItem = MutableLiveData<SeriesResponseModelItem>()

    fun updateList(itemsList: List<SeriesResponseModelItem>, selectedItem: MutableLiveData<SeriesResponseModelItem>){
        this.itemsList = itemsList
        this.selectedItem = selectedItem
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageView: ImageView = itemView.findViewById(R.id.imageview)
        private val seriesNameText: TextView = itemView.findViewById(R.id.textSerialName)
        private val languageText: TextView = itemView.findViewById(R.id.textLanguage)
        private val dateText: TextView = itemView.findViewById(R.id.textDate)

        fun bind(item: SeriesResponseModelItem, selectedItem: MutableLiveData<SeriesResponseModelItem>){
            if(item.show?.image != null ) {
                Glide.with(itemView.context)
                    .load(item.show.image.original).dontAnimate()
                    .circleCrop()
                    .into(imageView)
            }
            seriesNameText.text = item.show?.name
            languageText.text = item.show?.language
            dateText.text = item.show?.getFormattedDate()

            itemView.setOnClickListener{
                selectedItem.value = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_view_series_list, parent,false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemsList[position], selectedItem)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}