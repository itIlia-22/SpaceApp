package com.example.spaceapp.view.mainfragments.mainfragments.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spaceapp.utils.TODAY
import com.example.spaceapp.utils.YESTERDAY
import com.example.spaceapp.view.mainfragments.mainfragments.view.facts.FlightSpaceFragment
import com.example.spaceapp.view.mainfragments.mainfragments.view.facts.SpaceExplorationFragment
import com.example.spaceapp.view.mainfragments.mainfragments.view.facts.TopTenFragment


class FactsAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val ftagments = arrayOf(
        SpaceExplorationFragment,
        TopTenFragment,FlightSpaceFragment()
    )

    override fun getItemCount(): Int {
        return ftagments.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopTenFragment()
            1 -> SpaceExplorationFragment()
            2 -> FlightSpaceFragment()



            else -> {
                TopTenFragment()
            }
        }
    }


}