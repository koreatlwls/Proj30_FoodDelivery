package com.example.proj30_fooddelivery.widget.adapter.viewholder

import com.example.proj30_fooddelivery.databinding.ViewholderEmptyBinding
import com.example.proj30_fooddelivery.model.Model
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding: ViewholderEmptyBinding,
     viewModel : BaseViewModel,
     resourceProvider: ResourcesProvider
): ModelViewHolder<Model>(binding, viewModel, resourceProvider
) {
    override fun reset() = Unit

    override fun bindViews(model: Model, adapterListener: AdapterListener) = Unit
}