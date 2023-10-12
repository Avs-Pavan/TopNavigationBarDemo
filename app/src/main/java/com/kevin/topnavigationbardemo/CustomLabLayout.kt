package com.kevin.topnavigationbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kevin.topnavigationbardemo.databinding.ActivityCustomLabLayoutBinding
import com.kevin.topnavigationbardemo.databinding.TabItemBinding
import com.kevin.topnavigationbardemo.fragments.HomeFragment
import com.kevin.topnavigationbardemo.fragments.NotificationsFragment
import com.kevin.topnavigationbardemo.fragments.SettingsFragment

class CustomLabLayout : AppCompatActivity() {

    private val binding by lazy { ActivityCustomLabLayoutBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        // create list of fragments
        val fragments = listOf(
            HomeFragment.newInstance(),
            SettingsFragment.newInstance(),
        )

        // create adapter
        val adapter = ViewPagerAdapter(fragments, this)

        // set adapter to viewPager2
        with(binding) {
            viewPager2.adapter = adapter


            // attach tabLayout to viewPager2
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->

                val tabBinding = TabItemBinding.inflate(layoutInflater, tabLayout, false)
                tab.customView = tabBinding.root

                when (position) {
                    0 -> {
                        tabBinding.tabText.text = "Home"
                        tabBinding.tabIcon.setImageResource(R.drawable.baseline_home_24)
                    }

                    1 -> {
                        tabBinding.tabText.text = "Settings"
                        tabBinding.tabIcon.setImageResource(R.drawable.baseline_settings_24)
                    }

                }
            }.attach()
        }

    }
}