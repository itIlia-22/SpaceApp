package com.example.spaceapp.view.mainfragments.mainfragments.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.spaceapp.R
import com.example.spaceapp.databinding.FragmentMainBinding
import com.example.spaceapp.view.mainfragments.mainfragments.MainActivity
import com.example.spaceapp.view.mainfragments.mainfragments.photof.PhotoDayFragment
import com.example.spaceapp.view.mainfragments.mainfragments.view.facts.FactsFragment


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.apply {
            setTheme(R.style.Theme_SpaceApp)
        }

        binding.switchTheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(NO)

            }
        }

        wiki()
        (requireActivity() as MainActivity).setSupportActionBar(binding.bar.bottomAppBar)
        setHasOptionsMenu(true)


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun wiki() = binding.layoutInput.setEndIconOnClickListener {
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://en.wikipedia.org/wiki/${binding.wiki.text.toString()}")

        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_photo_day, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.photoDay -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out)
                    .replace(R.id.container, PhotoDayFragment.newInstance()).addToBackStack("")
                    .commit()
            }
            R.id.spaceFact -> {
                requireActivity().supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out)
                    .replace(R.id.container, FactsFragment.newInstance()).addToBackStack("")
                    .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
        const val YES = AppCompatDelegate.MODE_NIGHT_YES
        const val NO = AppCompatDelegate.MODE_NIGHT_NO

    }
}