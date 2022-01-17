package com.jatri.api.service

import com.jatri.apiresponse.PostItemApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {
    @GET("/posts")
    fun fetchPostList():Single<List<PostItemApiResponse>>

    @GET("/posts/{id}")
    fun fetchPostById(@Path("id")id:Int):Single<PostItemApiResponse>
}