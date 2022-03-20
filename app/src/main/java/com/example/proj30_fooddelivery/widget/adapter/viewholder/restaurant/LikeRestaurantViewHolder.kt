package com.example.proj30_fooddelivery.widget.adapter.viewholder.restaurant

import com.example.proj30_fooddelivery.R
import com.example.proj30_fooddelivery.databinding.ViewholderLikeRestaurantBinding
import com.example.proj30_fooddelivery.extensions.clear
import com.example.proj30_fooddelivery.extensions.load
import com.example.proj30_fooddelivery.model.restaurant.RestaurantModel
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener
import com.example.proj30_fooddelivery.widget.adapter.listener.restaurant.RestaurantLikeListListener
import com.example.proj30_fooddelivery.widget.adapter.viewholder.ModelViewHolder

class LikeRestaurantViewHolder(
    private val binding: ViewholderLikeRestaurantBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<RestaurantModel>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
        restaurantImage.clear()
    }

    override fun bindData(model: RestaurantModel) {
        super.bindData(model)
        with(binding) {
            restaurantImage.load(model.restaurantImageUrl, 24f)
            restaurantTitleText.text = model.restaurantTitle
            gradeText.text = resourcesProvider.getString(R.string.grade_format, model.grade)
            reviewCountText.text = resourcesProvider.getString(R.string.review_count, model.reviewCount)
            val (minTime, maxTime) = model.deliveryTimeRange
            deliveryTimeText.text = resourcesProvider.getString(R.string.delivery_time, minTime, maxTime)

            val (minTip, maxTip) = model.deliveryTipRange
            deliveryTipText.text = resourcesProvider.getString(R.string.delivery_tip, minTip, maxTip)
        }
    }

    override fun bindViews(model: RestaurantModel, adapterListener: AdapterListener) = with(binding) {
        if (adapterListener is RestaurantLikeListListener) {
            root.setOnClickListener {
                adapterListener.onClickItem(model)
            }
            likeImageButton.setOnClickListener {
                adapterListener.onDislikeItem(model)
            }
        }
    }

}