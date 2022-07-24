package com.example.spaceapp.view.mainfragments.mainfragments.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceapp.databinding.FragmentWeatherMarsBinding
import com.example.spaceapp.viewmodel.MyViewModel


class WeatherMarsFragment : Fragment() {
    private var _binding: FragmentWeatherMarsBinding? = null
    private val binding: FragmentWeatherMarsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWeatherMarsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            //renderData(it)
        })



    }




    companion object {
        @JvmStatic
        fun newInstance() = WeatherMarsFragment()
        private const val TODAY = 0
        private const val YESTERDAY = 1
        private const val BEFORE_YESTERDAY = 2
    }
}