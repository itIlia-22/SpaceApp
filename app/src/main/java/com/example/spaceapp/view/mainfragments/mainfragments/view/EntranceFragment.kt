package com.example.spaceapp.view.mainfragments.mainfragments.view

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import coil.load
import com.example.spaceapp.R
import com.example.spaceapp.databinding.EntranceFragmentStartBinding


class EntranceFragment : Fragment() {
    var isOpen: Boolean = false
    private var textIsVisible = false
    private var _binding: EntranceFragmentStartBinding? = null
    private val binding: EntranceFragmentStartBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testMain()
        binding.wikiButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out)
                .replace(R.id.container, MainFragment.newInstance()).addToBackStack("").commit()


        }

    }

    private fun testMain() {
        binding.imageView.load(R.drawable.animation_main){
            binding.imageView.setOnClickListener {
            val constraintSet = ConstraintSet()
            val transition = ChangeBounds()
            transition.duration = 2000L
            transition.interpolator = AnticipateOvershootInterpolator(1.5f)
                textIsVisible = !textIsVisible
                binding.text.visibility = if(textIsVisible) View.VISIBLE else View.GONE
            TransitionManager.beginDelayedTransition(binding.container, transition)
            isOpen = !isOpen
            if (isOpen) {
                constraintSet.clone(requireContext(), R.layout.entrance_fragment_start)
            } else {
                constraintSet.clone(requireContext(), R.layout.entrance_fragment_end)

            }

            constraintSet.applyTo(binding.container)

        }
    }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = EntranceFragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }




    companion object {
        @JvmStatic
        fun newInstance() = EntranceFragment()
    }
}