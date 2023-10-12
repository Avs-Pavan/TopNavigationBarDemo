package com.kevin.topnavigationbardemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kevin.topnavigationbardemo.fragments.HomeFragment
import com.kevin.topnavigationbardemo.fragments.NotificationsFragment
import com.kevin.topnavigationbardemo.fragments.SettingsFragment
import com.kevin.topnavigationbardemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {
        val fragments = listOf(
            HomeFragment.newInstance(),
            SettingsFragment.newInstance(),
            NotificationsFragment.newInstance()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        with(binding) {
            viewPager2.adapter = adapter
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