package com.example.spaceapp.view.mainfragments.mainfragments.view.facts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spaceapp.databinding.FragmentSpaceExplorationBinding


class SpaceExplorationFragment : Fragment() {
    private var _binding:FragmentSpaceExplorationBinding?= null
    private val binding:FragmentSpaceExplorationBinding
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
        _binding = FragmentSpaceExplorationBinding.inflate(inflater,container,false)
        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance() = SpaceExplorationFragment()
    }
}