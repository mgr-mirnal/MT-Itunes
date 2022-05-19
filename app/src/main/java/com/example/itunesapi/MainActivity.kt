package com.example.itunesapi

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.Nullable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.itunesapi.fragment.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val viewpager = findViewById<ViewPager>(R.id.tab_viewpager)
        val tablayout = findViewById<TabLayout>(R.id.tab_tablayout)


        // setSupportActionBar method
        setSupportActionBar(toolbar)

        setupViewPager(viewpager)

        // If we dont use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tablayout.setupWithViewPager(viewpager)

        val imageResId = intArrayOf(
            R.drawable.rock,
            R.drawable.classic,
            R.drawable.pop
        )

        for (i in imageResId.indices) {
            tablayout.getTabAt(i)?.setIcon(imageResId[i])
        }

    }


    private fun setupViewPager(tabViewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(Rock(), "Rock ")
        adapter.addFragment(Classic(), " Classic")
        adapter.addFragment(Pop(),"Pop")
        tabViewpager.setAdapter(adapter)

    }

    class ViewPagerAdapter : FragmentPagerAdapter {

        // objects of arraylist. One is of Fragment type and
        // another one is of String type.*/
        private final var fragmentList1: ArrayList<Fragment> = ArrayList()
        private final var fragmentTitleList1: ArrayList<String> = ArrayList()

        // this is a secondary constructor of ViewPagerAdapter class.
        public constructor(supportFragmentManager: FragmentManager)
                : super(supportFragmentManager)

        // returns which item is selected from arraylist of fragments.
        override fun getItem(position: Int): Fragment {
            return fragmentList1[position]
        }

        // returns which item is selected from arraylist of titles.
        @Nullable
        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList1.get(position)
        }
        override fun getCount(): Int {
            return fragmentList1.size
        }

        // this function adds the fragment and title in 2 separate  arraylist.
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }
}