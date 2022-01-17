package com.example.domain.usecase

import androidx.lifecycle.LiveData
import com.example.domain.repository.PostApiRepository
import com.jatri.entity.ApiResponse
import com.jatri.entity.PostItemApiEntity
import javax.inject.Inject

class PostDetailApiUseCase @Inject constructor(
    private val repository : PostApiRepository
) : ApiUseCase<Int, PostItemApiEntity>
{
    override fun execute(params: Int?): LiveData<ApiResponse<PostItemApiEntity>> = repository.fetchSinglePost(params!!)
}