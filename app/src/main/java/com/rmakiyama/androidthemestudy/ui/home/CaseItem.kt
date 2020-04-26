package com.rmakiyama.androidthemestudy.ui.home

import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.databinding.ItemCaseCardBinding
import com.rmakiyama.androidthemestudy.model.Case
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

data class CaseItem(
    val case: Case,
    val onClick: (case: Case) -> Unit
) : Item<GroupieViewHolder>() {

    override fun getLayout(): Int = R.layout.item_case_card

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val binding = ItemCaseCardBinding.bind(viewHolder.itemView)
        binding.title.text = case.title
        binding.description.text = case.description
        binding.root.setOnClickListener { onClick(case) }
    }
}
