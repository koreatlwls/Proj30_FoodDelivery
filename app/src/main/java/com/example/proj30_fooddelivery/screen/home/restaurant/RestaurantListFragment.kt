package com.example.proj30_fooddelivery.screen.home.restaurant

import android.os.Bundle
import com.example.proj30_fooddelivery.data.entity.location.LocationLatLngEntity
import com.example.proj30_fooddelivery.databinding.FragmentListBinding
import com.example.proj30_fooddelivery.model.restaurant.RestaurantModel
import com.example.proj30_fooddelivery.screen.base.BaseFragment
import com.example.proj30_fooddelivery.screen.home.restaurant.detail.RestaurantDetailActivity
import com.example.proj30_fooddelivery.widget.adapter.ModelRecyclerAdapter
import com.example.proj30_fooddelivery.widget.adapter.listener.restaurant.RestaurantListListener
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RestaurantListFragment : BaseFragment<RestaurantListViewModel, FragmentListBinding>() {

    override fun getViewBinding(): FragmentListBinding = FragmentListBinding.inflate(layoutInflater)

    private val restaurantCategory by lazy { arguments?.getSerializable(RESTAURANT_CATEGORY_KEY) as RestaurantCategory }
    private val locationLatLngEntity by lazy<LocationLatLngEntity> { arguments?.getParcelable(LOCATION_KEY)!! }

    override val viewModel by viewModel<RestaurantListViewModel> { parametersOf(restaurantCategory, locationLatLngEntity) }

    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantListViewModel>(listOf(), viewModel, adapterListener = object :
            RestaurantListListener {
            override fun onClickItem(model: RestaurantModel) {
                startActivity(
                    RestaurantDetailActivity.newIntent(requireContext(), model.toEntity())
                )
            }
        })
    }

    override fun initViews() = with(binding) {
        recyclerVIew.adapter = adapter
    }

    override fun observeData() {
        viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        const val RESTAURANT_KEY = "Restaurant"
        const val RESTAURANT_CATEGORY_KEY = "restaurantCategory"
        const val LOCATION_KEY = "location"

        fun newInstance(restaurantCategory: RestaurantCategory, locationLatLng: LocationLatLngEntity): RestaurantListFragment {
            val bundle = Bundle().apply {
                putSerializable(RESTAURANT_CATEGORY_KEY, restaurantCategory)
                putParcelable(LOCATION_KEY, locationLatLng)
            }

            return RestaurantListFragment().apply {
                arguments = bundle
            }
        }

    }
}