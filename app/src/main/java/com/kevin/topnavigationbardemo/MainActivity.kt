package com.kevin.topnavigationbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kevin.topnavigationbardemo.fragments.HomeFragment
import com.kevin.topnavigationbardemo.fragments.NotificationsFragment
import com.kevin.topnavigationbardemo.fragments.SettingsFragment
import com.kevin.topnavigationbardemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    // view binding for activity
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // call initViews
        initViews()

    }

    // initViews function to initialize views
    private fun initViews() {

        // create list of fragments
        val fragments = listOf(
            HomeFragment.newInstance(),
            SettingsFragment.newInstance(),
            NotificationsFragment.newInstance()
        )

        // create adapter
        val adapter = ViewPagerAdapter(fragments, this)

        // set adapter to viewPager2
        with(binding) {
            viewPager2.adapter = adapter


            // attach tabLayout to viewPager2
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    0 -> tab.text = "Home"
                    1 -> tab.text = "Settings"
                    2 -> tab.text = "Notifications"
                }
            }.attach()
        }


    }
}