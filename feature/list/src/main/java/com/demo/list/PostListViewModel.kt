package com.demo.list

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.PostListApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val postListApiUseCase: PostListApiUseCase
): ViewModel() {

    fun fetchPostList() = postListApiUseCase.execute()
}