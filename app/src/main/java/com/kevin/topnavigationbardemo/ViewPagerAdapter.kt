package com.kevin.topnavigationbardemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    private val fragments: List<Fragment>,
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {


    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]


}