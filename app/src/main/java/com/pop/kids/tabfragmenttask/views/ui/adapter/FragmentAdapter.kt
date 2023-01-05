package com.pop.kids.tabfragmenttask.views.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pop.kids.tabfragmenttask.views.ui.HomeFragment
import com.pop.kids.tabfragmenttask.views.ui.OtherFragment

class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1 -> OtherFragment()
            else -> HomeFragment()
        }
    }

}