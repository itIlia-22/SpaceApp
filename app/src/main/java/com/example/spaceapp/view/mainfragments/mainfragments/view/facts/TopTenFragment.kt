package com.example.spaceapp.view.mainfragments.mainfragments.view.facts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaceapp.databinding.FragmentTopTenFactsBinding


class TopTenFragment : Fragment() {
    private var _binding:FragmentTopTenFactsBinding?= null
    private val binding:FragmentTopTenFactsBinding
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
        _binding = FragmentTopTenFactsBinding.inflate(inflater,container,false)
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance() = TopTenFragment()
    }
}