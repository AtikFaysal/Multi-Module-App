package com.example.domain.usecase

import androidx.lifecycle.LiveData
import com.example.domain.repository.PostApiRepository
import com.jatri.entity.ApiResponse
import com.jatri.entity.PostItemApiEntity
import javax.inject.Inject

class PostListApiUseCase @Inject constructor(
    private val postApiRepository: PostApiRepository
): ApiUseCase<Unit,List<PostItemApiEntity>>{
    override fun execute(params: Unit?): LiveData<ApiResponse<List<PostItemApiEntity>>> {
        return postApiRepository.fetchPostList()
    }
}