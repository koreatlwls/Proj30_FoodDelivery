package com.example.proj30_fooddelivery.screen.like

import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.proj30_fooddelivery.databinding.FragmentRestaurantLikeListBinding
import com.example.proj30_fooddelivery.model.restaurant.RestaurantModel
import com.example.proj30_fooddelivery.screen.base.BaseFragment
import com.example.proj30_fooddelivery.screen.home.restaurant.detail.RestaurantDetailActivity
import com.example.proj30_fooddelivery.widget.adapter.ModelRecyclerAdapter
import com.example.proj30_fooddelivery.widget.adapter.listener.restaurant.RestaurantLikeListListener
import org.koin.android.viewmodel.ext.android.viewModel

class RestaurantLikeListFragment: BaseFragment<RestaurantLikeListViewModel, FragmentRestaurantLikeListBinding>() {

    override fun getViewBinding(): FragmentRestaurantLikeListBinding = FragmentRestaurantLikeListBinding.inflate(layoutInflater)

    override val viewModel by viewModel<RestaurantLikeListViewModel>()

    private var isFirstShown = false

    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantLikeListViewModel>(listOf(), viewModel, adapterListener = object :
            RestaurantLikeListListener {

            override fun onDislikeItem(model: RestaurantModel) {
                viewModel.dislikeRestaurant(model.toEntity())
            }

            override fun onClickItem(model: RestaurantModel) {
                startActivity(
                    RestaurantDetailActivity.newIntent(requireContext(), model.toEntity())
                )
            }
        })
    }

    override fun onResume() {
        super.onResume()
        if (isFirstShown.not()) {
            isFirstShown = true
        } else {
            viewModel.fetchData()
        }
    }

    override fun initViews() = with(binding) {
        recyclerView.adapter = adapter
    }

    override fun observeData() {
        viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
            checkListEmpty(it)
        }
    }

    private fun checkListEmpty(restaurantList: List<RestaurantModel>) {
        val isEmpty = restaurantList.isEmpty()
        binding.recyclerView.isGone = isEmpty
        binding.emptyResultTextView.isVisible = isEmpty
        if (isEmpty.not()) {
            adapter.submitList(restaurantList)
        }
    }

    companion object {

        fun newInstance() = RestaurantLikeListFragment()

        const val TAG = "likeFragment"

    }

}