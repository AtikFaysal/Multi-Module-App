package com.demo.details

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.PostDetailApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(private val postDetailApiUseCase: PostDetailApiUseCase) : ViewModel()
{
    fun fetchPostDetails(id : Int) = postDetailApiUseCase.execute(id)
}