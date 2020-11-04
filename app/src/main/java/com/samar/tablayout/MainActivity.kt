package com.samar.tablayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
private lateinit var tabLayout: TabLayout
private lateinit var tabViewPager: ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.taps)
        tabViewPager = findViewById(R.id.pager)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, tab?.text.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })

        tabViewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeFragment.newInstance(position, "")
                    1 -> HomeFragment.newInstance(position, "")
                    2 -> HomeFragment.newInstance(position, "")
                    else ->HomeFragment.newInstance(position, "")
                }
            }

            override fun getItemCount(): Int {
                return 3


            }
        }

        TabLayoutMediator(tabLayout, tabViewPager) { tab, position ->
            val tab1 = when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.ic_baseline_local_airport_24)
                }
                1 -> {
                    tab.text = "Food"
                    tab.setIcon(R.drawable.ic_baseline_local_dining_24)
                }
                2 -> {
                    tab.text = "Hotel"
                    tab.setIcon(R.drawable.ic_baseline_home_work_24)
                }
                else -> null
            }


        }.attach()
    }
}