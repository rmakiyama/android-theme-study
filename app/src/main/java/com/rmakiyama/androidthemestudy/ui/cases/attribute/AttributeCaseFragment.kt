package com.rmakiyama.androidthemestudy.ui.cases.attribute

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.core.ext.assistedViewModels
import com.rmakiyama.androidthemestudy.databinding.FragmentAttributeCaseBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Provider

class AttributeCaseFragment : DaggerFragment(R.layout.fragment_attribute_case) {

    @Inject lateinit var factory: Provider<AttributeCaseViewModel>
    private val viewModel by assistedViewModels { factory.get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val themedInflater =
            inflater.cloneInContext(
                ContextThemeWrapper(requireContext(), R.style.AndroidThemeStudy_Dense)
            )
        return super.onCreateView(themedInflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAttributeCaseBinding.bind(view)
        val dummyAdapter = GroupAdapter<GroupieViewHolder>()
        binding.dummies.adapter = dummyAdapter
        viewModel.dummies.observe(viewLifecycleOwner) { dummies ->
            dummyAdapter.update(dummies.map(::DummyItem))
        }
    }
}
