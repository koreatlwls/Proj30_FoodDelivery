package com.example.proj30_fooddelivery.screen.main.home.restaurant

import android.util.Log
import androidx.core.os.bundleOf
import com.example.proj30_fooddelivery.databinding.FragmentRestaurantListBinding
import com.example.proj30_fooddelivery.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RestaurantListFragment :
    BaseFragment<RestaurantListViewModel, FragmentRestaurantListBinding>() {

    private val restaurantCategory by lazy {arguments?.getSerializable(RESTAURANT_CATEGORY_KEY) as RestaurantCategory}

    override val viewModel by viewModel<RestaurantListViewModel> { parametersOf(restaurantCategory)}

    override fun getViewBinding(): FragmentRestaurantListBinding =
        FragmentRestaurantListBinding.inflate(layoutInflater)

    override fun observeData() = viewModel.restaurantListLiveData.observe(viewLifecycleOwner){
        Log.e("restaurantList",it.toString())
    }

    companion object {

        const val RESTAURANT_CATEGORY_KEY = "restaurantCategory"

        fun newInstance(restaurantCategory: RestaurantCategory): RestaurantListFragment {
            return RestaurantListFragment().apply {
                arguments = bundleOf(
                    RESTAURANT_CATEGORY_KEY to restaurantCategory
                )
            }
        }
    }
}