package com.example.spaceapp.view.mainfragments.mainfragments.photof

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.spaceapp.R
import com.example.spaceapp.databinding.FragmentBeforeYesterdayBinding
import com.example.spaceapp.viewmodel.AppState
import com.example.spaceapp.viewmodel.MyViewModel


class PhotoDayBeforeYesterdayFragment : Fragment() {
    var Open:Boolean=false
    private var _binding:FragmentBeforeYesterdayBinding?= null
    private val binding:FragmentBeforeYesterdayBinding
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer {
            renderData(it)
        })
        viewModel.dayRequest(YESTERDAY)
        AnimationImage()

    }

    private fun AnimationImage(){
        binding.appCompatImageView.setOnClickListener {
            Open = !Open
            val transitionImage = ChangeImageTransform()
            transitionImage.duration = 2000
            binding.appCompatImageView.scaleType =
                if (Open){
                    ImageView.ScaleType.CENTER_CROP
                }else{
                    ImageView.ScaleType.CENTER_INSIDE
                }
            TransitionManager.beginDelayedTransition(binding.animationContainer, transitionImage)

        }

    }

    private fun renderData(dataState: AppState) {
        when(dataState){
            is AppState.Success ->{
                binding.appCompatImageView.load(dataState.dataPhotoDay.url){
                    binding.title.text = dataState.dataPhotoDay.title
                    binding.exp.text = dataState.dataPhotoDay.explanation
                    val transition = ChangeBounds()
                    transition.duration = 3000L
                    TransitionManager.beginDelayedTransition(binding.animationContainer,transition)
                }
            }
            is AppState.Loading->{
                binding.appCompatImageView.load(R.drawable.animation_load)
            }
            is AppState.Error->{
                dataState.throwable.message
            }
            else -> {}
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeforeYesterdayBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = PhotoDayBeforeYesterdayFragment()
        private const val YESTERDAY = 1

    }
}