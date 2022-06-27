package com.example.feature.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.base.BaseRecyclerAdapter
import com.example.feature.databinding.RowBookItemLayoutBinding
import com.example.feature.model.BookUiModel

/**
 * Adapter class for RecyclerView
 */
class BooksAdapter constructor(
    private val clickFunc : ((BookUiModel?) -> Unit)? = null
) : BaseRecyclerAdapter<BookUiModel, RowBookItemLayoutBinding, BookViewHolder>(AuthorItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = RowBookItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )


        return BookViewHolder(binding = binding, click = clickFunc)

    }

}

class AuthorItemDiffUtil : DiffUtil.ItemCallback<BookUiModel>() {
    override fun areItemsTheSame(oldItem: BookUiModel, newItem: BookUiModel): Boolean {
        return oldItem.uid == newItem.uid
    }

    override fun areContentsTheSame(oldItem: BookUiModel, newItem: BookUiModel): Boolean {
        return oldItem == newItem
    }
}