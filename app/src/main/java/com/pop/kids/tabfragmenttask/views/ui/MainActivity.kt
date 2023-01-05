package com.pop.kids.tabfragmenttask.views.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.pop.kids.tabfragmenttask.R
import com.pop.kids.tabfragmenttask.views.ui.adapter.FragmentAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var selectedBottomTab = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = FragmentAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            selectedBottomTab = position
            tab.text = "Tab ${position}"
        }.attach()
    }

    override fun onBackPressed() {
        if(tabLayout.selectedTabPosition == 0 && supportFragmentManager.backStackEntryCount > 0){
            supportFragmentManager.popBackStack()
        }else {
            finish()
        }
    }
}