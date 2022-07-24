package com.example.spaceapp.view.mainfragments.mainfragments.view.facts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.spaceapp.R
import com.example.spaceapp.databinding.FragmentFactsBinding
import com.example.spaceapp.view.mainfragments.mainfragments.viewPager.FactsAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator


class FactsFragment : Fragment() {
    private var _binding:FragmentFactsBinding?= null
    private val binding:FragmentFactsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ViewPager.adapter = FactsAdapter(requireActivity())
        setTabs()


    }

    private fun setTabs(){
        try {
            TabLayoutMediator(binding.TabLayout,binding.ViewPager){tab,posotoin ->
                tab.icon = when(posotoin){
                    0 ->{
                        ContextCompat.getDrawable(requireContext(), R.drawable.planet_space_icon)
                    }
                    1 ->{
                        ContextCompat.getDrawable(requireContext(), R.drawable.telescopeo)
                    }
                    2 ->{
                        ContextCompat.getDrawable(requireContext(), R.drawable.rocket)
                    }

                    else -> { ContextCompat.getDrawable(requireContext(), R.drawable.rocket)}
                }


            }.attach()
        }catch (e:IllegalStateException){
            Toast.makeText(requireContext(),"Error",Toast.LENGTH_LONG).show()
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFactsBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FactsFragment()

    }
}