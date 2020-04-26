package com.rmakiyama.androidthemestudy.ui.cases.pro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.data.UserStatusSetting
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProCaseFragment : DaggerFragment(R.layout.fragment_pro_case) {

    @Inject lateinit var status: UserStatusSetting

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val themedInflater: LayoutInflater = if (status.isProMode) {
            inflater.cloneInContext(
                ContextThemeWrapper(requireContext(), R.style.AndroidThemeStudy_Pro)
            )
        } else inflater
        return super.onCreateView(themedInflater, container, savedInstanceState)
    }
}
