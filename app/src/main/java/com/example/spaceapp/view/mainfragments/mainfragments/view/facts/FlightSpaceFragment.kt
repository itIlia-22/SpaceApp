package com.example.spaceapp.view.mainfragments.mainfragments.view.facts

import android.os.Bundle
import android.transition.ChangeImageTransform
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.spaceapp.databinding.FragmentFlightIntoSpaceBinding
import com.example.spaceapp.databinding.FragmentTopTenFactsBinding


class FlightSpaceFragment : Fragment() {
    private var _binding:FragmentFlightIntoSpaceBinding?= null
    private val binding:FragmentFlightIntoSpaceBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightIntoSpaceBinding.inflate(inflater,container,false)
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance() = FlightSpaceFragment()
    }
}