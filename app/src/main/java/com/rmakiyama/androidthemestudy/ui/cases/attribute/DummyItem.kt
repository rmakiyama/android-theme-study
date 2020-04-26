package com.rmakiyama.androidthemestudy.ui.cases.attribute

import com.rmakiyama.androidthemestudy.R
import com.rmakiyama.androidthemestudy.databinding.ItemDummyCardBinding
import com.rmakiyama.androidthemestudy.model.Dummy
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

data class DummyItem(val dummy: Dummy) : Item<GroupieViewHolder>() {

    override fun getLayout(): Int = R.layout.item_dummy_card

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val binding = ItemDummyCardBinding.bind(viewHolder.itemView)
        binding.title.text = dummy.id
    }
}
