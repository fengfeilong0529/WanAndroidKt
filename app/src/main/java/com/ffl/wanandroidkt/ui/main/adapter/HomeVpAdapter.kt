package com.ffl.wanandroidkt.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeVpAdapter(fm: FragmentManager, fragments : ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    private val mFragments : ArrayList<Fragment> = fragments

    override fun getItem(position: Int): Fragment =  mFragments[position]

    override fun getCount(): Int =mFragments.size
}