package com.rmakiyama.androidthemestudy.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.core.ext.assistedViewModels
import com.rmakiyama.androidthemestudy.data.UserStatusSetting
import com.rmakiyama.androidthemestudy.databinding.FragmentHomeBinding
import com.rmakiyama.androidthemestudy.model.Case
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : DaggerFragment(R.layout.fragment_home) {

    @Inject lateinit var status: UserStatusSetting
    @Inject lateinit var factory: Provider<HomeViewModel>
    private val viewModel by assistedViewModels { factory.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        val casesAdapter = GroupAdapter<GroupieViewHolder>()
        binding.cases.adapter = casesAdapter
        binding.switchPro.apply {
            isChecked = status.isProMode
            setOnCheckedChangeListener { _, _ -> status.toggleProMode() }
        }

        with(viewModel) {
            cases.observe(viewLifecycleOwner) { cases ->
                casesAdapter.update(cases.map { CaseItem(it, onClickCase) })
            }
        }
    }

    private val onClickCase: (case: Case) -> Unit = { case ->
        when (case) {
            Case.DIALOG -> findNavController().navigate(R.id.dialog_case)
            Case.PRO -> findNavController().navigate(R.id.pro_case)
            Case.ATTRIBUTE -> findNavController().navigate(R.id.attribute_case)
        }
    }
}
