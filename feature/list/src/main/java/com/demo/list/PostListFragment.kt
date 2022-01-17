package com.demo.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.demo.list.databinding.PostListFragmentBinding
import com.jatri.common.base.BaseFragment
import com.jatri.common.extfun.setUpVerticalRecyclerView
import com.jatri.entity.ApiResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListFragment : BaseFragment<PostListFragmentBinding>() {
    override fun viewBindingLayout(): PostListFragmentBinding  =  PostListFragmentBinding.inflate(layoutInflater)

    private val viewModel by viewModels<PostListViewModel>()
    private val adapter = PostListAdapter()

    override fun initializeView(savedInstanceState: Bundle?) {
        requireActivity().setUpVerticalRecyclerView(binding.listRv,adapter)
        fetchPostList()
    }

    private fun fetchPostList(){
        viewModel.fetchPostList().observe(viewLifecycleOwner,{apiResponse->
            when(apiResponse){
                is ApiResponse.Success->{
                    //showToastMessage(apiResponse.data[0].title)
                    adapter.submitList(apiResponse.data.toList())
                }
                is ApiResponse.Failure->showToastMessage(apiResponse.message)
                is ApiResponse.Progress->showProgressBar(apiResponse.loading,binding.progressBar)
            }
        })
    }
}