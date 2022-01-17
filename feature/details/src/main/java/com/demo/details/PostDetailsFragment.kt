package com.demo.details

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.details.databinding.PostDetailsFrgmentBinding
import com.jatri.common.base.BaseFragment
import com.jatri.common.utils.AppConstants.Companion.postId
import com.jatri.entity.ApiResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : BaseFragment<PostDetailsFrgmentBinding>() {
    override fun viewBindingLayout(): PostDetailsFrgmentBinding  =  PostDetailsFrgmentBinding.inflate(layoutInflater)

    private val viewModel by viewModels<PostDetailsViewModel>()

    override fun initializeView(savedInstanceState: Bundle?) {
        fetchPostDetails()
    }

    private  fun fetchPostDetails()
    {
        viewModel.fetchPostDetails(requireArguments().getInt(postId)).observe(viewLifecycleOwner, {
            when(it){
                is ApiResponse.Success->{
                    binding.postIdTv.text = it.data.postId.toString()
                    binding.postDetailsTv.text = it.data.title
                }
                is ApiResponse.Failure-> showToastMessage("No data found")
                is ApiResponse.Progress->showProgressBar(it.loading, binding.progressBar)
            }
        })
    }
}