package com.example.spaceapp.view.mainfragments.mainfragments.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.spaceapp.utils.BEFORE_YESTERDAY
import com.example.spaceapp.utils.TODAY
import com.example.spaceapp.utils.YESTERDAY
import com.example.spaceapp.view.mainfragments.mainfragments.photof.PhotoDayBeforeYesterdayFragment
import com.example.spaceapp.view.mainfragments.mainfragments.photof.PhotoDayTodayFragment
import com.example.spaceapp.view.mainfragments.mainfragments.photof.PhotoDayYesterdayFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val ftagments = arrayOf(
        PhotoDayTodayFragment(),
        PhotoDayYesterdayFragment(),
        PhotoDayBeforeYesterdayFragment()
    )

    override fun getCount(): Int {
        return ftagments.size
    }

    override fun getItem(position: Int): Fragment {
      return  when (position) {
            TODAY -> PhotoDayTodayFragment()
            YESTERDAY -> PhotoDayYesterdayFragment()
            BEFORE_YESTERDAY -> PhotoDayBeforeYesterdayFragment()

          else -> {PhotoDayTodayFragment()}
      }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            TODAY->"Today"
            YESTERDAY->"Yesterday"
            else -> "BeforeYesterday"
        }
    }


}