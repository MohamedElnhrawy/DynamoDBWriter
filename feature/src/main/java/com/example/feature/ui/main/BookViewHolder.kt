package com.example.feature.ui.main

import com.example.base.BaseViewHolder
import com.example.feature.databinding.RowBookItemLayoutBinding
import com.example.feature.model.BookUiModel

/**
 * ViewHolder class for book
 */
class BookViewHolder constructor(
    private val binding : RowBookItemLayoutBinding,
    private val click : ((BookUiModel?) -> Unit)? = null
) : BaseViewHolder<BookUiModel, RowBookItemLayoutBinding>(binding) {


    init {
        binding.container.setOnClickListener {
            click?.invoke(getRowItem())
        }
    }

    override fun bind() {


        getRowItem()?.let {
            binding.book = it
            binding.executePendingBindings()

        }
    }
}