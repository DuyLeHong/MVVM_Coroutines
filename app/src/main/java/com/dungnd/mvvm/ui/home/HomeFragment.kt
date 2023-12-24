package com.dungnd.mvvm.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dungnd.mvvm.R
import com.dungnd.mvvm.databinding.FragmentHomeBinding
import com.dungnd.mvvm.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private val adapter = PhotoListAdapter()

    override fun layoutRes(): Int = R.layout.fragment_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun initView() {
        adapter.onPhotoClick = {
            findNavController().navigate(
                R.id.action_homeFragment_to_detailFragment,
                bundleOf(
                    Pair("key", it?.title)
                )
            )
        }
        binding.rcvData.adapter = adapter
        viewModel.name.observe(this) {
            binding.tvName.text = it
        }
        viewModel.photoList.observe(this) {
            binding.tvName.text = it.size.toString()
            adapter.photoList = it
            adapter.notifyDataSetChanged()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val savedRecyclerLayoutState =
            savedInstanceState?.getParcelable("BUNDLE_RECYCLER_LAYOUT") as? Parcelable
        if (savedRecyclerLayoutState != null) {
            binding.rcvData.layoutManager?.onRestoreInstanceState(savedRecyclerLayoutState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(
            "BUNDLE_RECYCLER_LAYOUT",
            binding.rcvData.layoutManager?.onSaveInstanceState()
        )
    }
}