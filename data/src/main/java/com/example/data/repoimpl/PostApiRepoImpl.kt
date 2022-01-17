package com.example.data.repoimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.data.mapper.PostApiMapper
import com.example.data.mapper.PostDetailApiMapper
import com.example.data.mapper.mapFromApiResponse
import com.example.data.wrapper.NetworkBoundResource
import com.example.domain.repository.PostApiRepository
import com.jatri.api.service.PostApiService
import com.jatri.apiresponse.PostItemApiResponse
import com.jatri.entity.ApiResponse
import com.jatri.entity.PostItemApiEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostApiRepoImpl @Inject constructor(
    private val postApiService: PostApiService,
    private val postApiMapper: PostApiMapper,
    private val postDetailApiMapper: PostDetailApiMapper
):PostApiRepository{

    override fun fetchPostList(): LiveData<ApiResponse<List<PostItemApiEntity>>> {
        return  object : NetworkBoundResource<List<PostItemApiResponse>>(){
            override fun createCall(): Single<List<PostItemApiResponse>> = postApiService.fetchPostList()
        }.asLiveData().map {data->
            mapFromApiResponse(data,postApiMapper)
        }
    }

    override fun fetchSinglePost(id: Int): LiveData<ApiResponse<PostItemApiEntity>> {
        return  object : NetworkBoundResource<PostItemApiResponse>(){
            override fun createCall(): Single<PostItemApiResponse> = postApiService.fetchPostById(id)
        }.asLiveData().map {data->
            mapFromApiResponse(data,postDetailApiMapper)
        }
    }
}