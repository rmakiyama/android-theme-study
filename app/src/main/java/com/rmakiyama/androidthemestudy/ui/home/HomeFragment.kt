package com.rmakiyama.androidthemestudy.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.core.ext.assistedViewModels
import com.rmakiyama.androidthemestudy.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : DaggerFragment(R.layout.fragment_home) {

    @Inject lateinit var factory: Provider<HomeViewModel>
    private val viewModel by assistedViewModels { factory.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

        with(viewModel) {
            time.observe(viewLifecycleOwner, binding.countUp::setText)
            dummies.observe(viewLifecycleOwner) { Timber.i("$it") }
        }
    }
}
