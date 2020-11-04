package com.samar.tablayout

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Travel")
        adapter.addFragment(SettingsFragment(), "Food")
        adapter.addFragment(FavouritesFragment(), "Hotel")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_local_airport_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_local_dining_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_home_work_24)
    }


}