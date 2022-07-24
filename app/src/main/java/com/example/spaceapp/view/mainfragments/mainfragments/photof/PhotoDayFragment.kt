package com.example.spaceapp.view.mainfragments.mainfragments.photof

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaceapp.databinding.FragmentDayPhotoBinding
import com.example.spaceapp.view.mainfragments.mainfragments.viewPager.ViewPagerAdapter


class PhotoDayFragment : Fragment() {
    private var _binding:FragmentDayPhotoBinding?= null
    private val binding:FragmentDayPhotoBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ViewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        binding.TabLayout.setupWithViewPager(binding.ViewPager)

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayPhotoBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = PhotoDayFragment()

    }
}