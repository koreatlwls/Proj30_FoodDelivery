package com.example.proj30_fooddelivery.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.proj30_fooddelivery.databinding.ViewholderEmptyBinding
import com.example.proj30_fooddelivery.databinding.ViewholderRestaurantBinding
import com.example.proj30_fooddelivery.model.CellType
import com.example.proj30_fooddelivery.model.Model
import com.example.proj30_fooddelivery.screen.base.BaseViewModel
import com.example.proj30_fooddelivery.util.provider.ResourcesProvider
import com.example.proj30_fooddelivery.widget.adapter.viewholder.EmptyViewHolder
import com.example.proj30_fooddelivery.widget.adapter.viewholder.ModelViewHolder
import com.example.proj30_fooddelivery.widget.adapter.viewholder.restaurant.RestaurantViewHolder

object ModelViewHolderMapper {

    fun <M : Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ): ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when(type){
            CellType.EMPTY_CELL -> EmptyViewHolder(
                ViewholderEmptyBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
            CellType.RESTAURANT_CELL -> RestaurantViewHolder(
                ViewholderRestaurantBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
        }
        return viewHolder as ModelViewHolder<M>
    }
}