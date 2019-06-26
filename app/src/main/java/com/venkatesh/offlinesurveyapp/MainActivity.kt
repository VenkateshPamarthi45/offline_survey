package com.venkatesh.offlinesurveyapp

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import com.venkatesh.offlinesurveyapp.image_survey.view.ImageSurveyFragment
import com.venkatesh.offlinesurveyapp.items.view.ItemListingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.viewpager)
        setupViewPager()

        tabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
        AppCompatDelegate.setDefaultNightMode(2)
    }

    /**
     * Viewpager adapter is set in this method
     * adding trending fragment and favourite fragment to adapter
     * and setting view pager adapter with added fragments
     *
     */
    private fun setupViewPager() {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(ItemListingFragment.newInstance(),getString(R.string.tab_title_survey))
        viewPagerAdapter.addFragment(ImageSurveyFragment.newInstance(),getString(R.string.tab_title_image_survey))
        viewPager.adapter = viewPagerAdapter
    }

    /**
     * This method helps to get [CountingIdlingResource]
     * from [ItemListingFragment] for testing
     */
    fun getCountingIdlingResource(): CountingIdlingResource {
        return ItemListingFragment.getCountingIdlingResource()
    }

    /**
     * This class extends [FragmentPagerAdapter]
     * adding trending and favourite fragments to [getSupportFragmentManager]
     *
     *  @param fm Fragment Manager
     */
    class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        private val mFragmentList = mutableListOf<Fragment>()
        private val mFragmentTitleList = mutableListOf<String>()

        fun addFragment(fragment: Fragment, title:String){
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }


        override fun getItem(p0: Int): Fragment {
            return mFragmentList[p0]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

    }
}
