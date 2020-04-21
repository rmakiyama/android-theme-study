package com.rmakiyama.androidthemestudy.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.core.ext.assistedViewModels
import com.rmakiyama.androidthemestudy.databinding.FragmentDetailBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment(R.layout.fragment_detail) {

    @Inject lateinit var factory: DetailViewModel.Factory
    private val viewModel by assistedViewModels { factory.create(navArgs.id) }

    private val navArgs: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        with(viewModel) {
            id.observe(viewLifecycleOwner) { binding.uuid.text = it }
        }
    }
}
