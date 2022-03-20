package com.example.proj30_fooddelivery.widget.adapter.viewholder.order

import com.example.proj30_fooddelivery.R
import com.example.proj30_fooddelivery.databinding.ViewholderOrderBinding
import com.example.proj30_fooddelivery.model.order.OrderModel
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.example.proj30_fooddelivery.widget.adapter.listener.AdapterListener
import com.example.proj30_fooddelivery.widget.adapter.listener.order.OrderListListener
import com.example.proj30_fooddelivery.widget.adapter.viewholder.ModelViewHolder

class OrderViewHolder(
    private val binding: ViewholderOrderBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
) : ModelViewHolder<OrderModel>(binding, viewModel, resourcesProvider) {

    override fun reset() {
        binding.orderContentText.text = ""
    }

    override fun bindData(model: OrderModel) {
        super.bindData(model)
        with(binding) {
            orderTitleText.text = resourcesProvider.getString(R.string.order_history_title, model.orderId)

            val foodMenuList = model.foodMenuList

            foodMenuList
                .groupBy { it.title }
                .entries.forEach { (title, menuList) ->
                    val orderDataStr =
                        orderContentText.text.toString() + "메뉴 : $title | 가격 : ${menuList.first().price}원 X ${menuList.size}\n"
                    orderContentText.text = orderDataStr
                }
            orderContentText.text = orderContentText.text.trim()

            orderTotalPriceText.text =
                resourcesProvider.getString(R.string.price, foodMenuList.map { it.price }.reduce { total, price -> total + price })
        }
    }

    override fun bindViews(model: OrderModel, adapterListener: AdapterListener) {
        if (adapterListener is OrderListListener) {
            binding.root.setOnClickListener {
                adapterListener.writeRestaurantReview(model.orderId, model.restaurantTitle)
            }
        }
    }

}