package com.example.data.mapper

import com.jatri.apiresponse.PostItemApiResponse
import com.jatri.entity.PostItemApiEntity
import javax.inject.Inject

class PostApiMapper @Inject constructor() : Mapper<List<PostItemApiResponse>,List<PostItemApiEntity>>{
    override fun mapFromApiResponse(type: List<PostItemApiResponse>): List<PostItemApiEntity> {
        return type.map {
            PostItemApiEntity(
                title = it.title ?: "",
                postId = it.id ?: -1
            )
        }
    }
}