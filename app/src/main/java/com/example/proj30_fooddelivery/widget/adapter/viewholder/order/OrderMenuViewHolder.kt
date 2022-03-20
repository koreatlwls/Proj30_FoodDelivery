package com.example.proj30_fooddelivery.widget.adapter.viewholder.order

import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.proj30_fooddelivery.R
import com.example.proj30_fooddelivery.databinding.ViewholderOrderMenuBinding
import com.example.proj30_fooddelivery.extensions.clear
import com.example.proj30_fooddelivery.extensions.load
import com.example.proj30_fooddelivery.model.restaurant.FoodModel
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener
import com.example.proj30_fooddelivery.widget.adapter.listener.order.OrderMenuListListener
import com.example.proj30_fooddelivery.widget.adapter.viewholder.ModelViewHolder

class OrderMenuViewHolder(
    private val binding: ViewholderOrderMenuBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<FoodModel>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
        foodImage.clear()
    }

    override fun bindData(model: FoodModel) {
        super.bindData(model)
        with(binding) {
            foodImage.load(model.imageUrl, 24f, CenterCrop())
            foodTitleText.text = model.title
            foodDescriptionText.text = model.description
            priceText.text = resourcesProvider.getString(R.string.price, model.price)
        }
    }

    override fun bindViews(model: FoodModel, adapterListener: AdapterListener) {
        if (adapterListener is OrderMenuListListener) {
            binding.root.setOnClickListener {
                adapterListener.onRemoveItem(model)
            }
        }
    }

}