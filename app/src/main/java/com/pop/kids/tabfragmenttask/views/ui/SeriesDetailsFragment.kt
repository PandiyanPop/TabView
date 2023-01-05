package com.pop.kids.tabfragmenttask.views.ui

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.pop.kids.tabfragmenttask.R
import com.pop.kids.tabfragmenttask.views.movies.model.SeriesResponseModelItem

class SeriesDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receivedDetails: SeriesResponseModelItem? = arguments?.getParcelable("ParcelKey")

        receivedDetails?.run {
            view.findViewById<TextView>(R.id.textSeriesName).text = show?.name
            view.findViewById<TextView>(R.id.textLanguage).text = show?.language
            view.findViewById<TextView>(R.id.textDate).text = show?.getFormattedDate()
            show?.summary?.let { view.findViewById<TextView>(R.id.textSummary).text = Html.fromHtml(it, Html.FROM_HTML_MODE_COMPACT) }

            if(show?.image != null ) {
                context?.let {
                    Glide.with(it)
                        .load(show.image.original).dontAnimate()
//                        .circleCrop()
                        .into(view.findViewById(R.id.imageView))
                }
            }
        }

    }
}