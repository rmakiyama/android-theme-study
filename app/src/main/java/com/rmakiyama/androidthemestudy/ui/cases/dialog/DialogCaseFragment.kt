package com.rmakiyama.androidthemestudy.ui.cases.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.core.ext.assistedViewModels
import com.rmakiyama.androidthemestudy.databinding.FragmentDialogCaseBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Provider

class DialogCaseFragment : DaggerFragment(R.layout.fragment_dialog_case) {

    @Inject lateinit var factory: Provider<DialogCaseViewModel>
    private val viewModel by assistedViewModels { factory.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDialogCaseBinding.bind(view)

        binding.normal.setOnClickListener {
            showDialog(requireContext())
        }
        binding.contextThemeWrapper.setOnClickListener {
            val themedContext =
                ContextThemeWrapper(
                    requireContext(),
                    R.style.ThemeOverlay_AndroidThemeStudy_Dialog
                )
            showDialog(themedContext)
        }
        binding.normalCustom.setOnClickListener {
            showDialogWithCustomView(requireContext())
        }
        binding.inflaterCustom.setOnClickListener {
            val themedContext =
                ContextThemeWrapper(
                    requireContext(),
                    R.style.ThemeOverlay_AndroidThemeStudy_Dialog
                )
            showDialogWithCustomView(themedContext)
        }
        binding.contextThemeWrapperCustom.setOnClickListener {
            val themedContext =
                ContextThemeWrapper(
                    requireContext(),
                    R.style.ThemeOverlay_AndroidThemeStudy_Dialog
                )
            showDialogWithCustomView2(themedContext)
        }
    }

    private fun showDialog(context: Context) {
        MaterialAlertDialogBuilder(context)
            .setTitle("ダイアログ")
            .setMessage("ダイアログのメッセージです")
            .setPositiveButton("はい") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("いいえ") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun showDialogWithCustomView(context: Context) {
        val customView =
            layoutInflater.inflate(R.layout.view_dialog_body, null, false)
        MaterialAlertDialogBuilder(context)
            .setTitle("カスタムビューを使ってます")
            .setView(customView)
            .setPositiveButton("はい") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("いいえ") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun showDialogWithCustomView2(context: Context) {
        // layoutInflaterを別のContextを使ってコピー
        val themedInflater = layoutInflater.cloneInContext(context)
        // コピーしたlayoutInflaterを使ってViewを生成
        val customView =
            themedInflater.inflate(R.layout.view_dialog_body, null, false)
        MaterialAlertDialogBuilder(context)
            .setTitle("カスタムビューを使ってます")
            .setView(customView)
            .setPositiveButton("はい") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("いいえ") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}
