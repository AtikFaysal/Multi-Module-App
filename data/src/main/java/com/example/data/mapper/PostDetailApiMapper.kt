package com.example.data.mapper

import com.jatri.apiresponse.PostItemApiResponse
import com.jatri.entity.PostItemApiEntity
import javax.inject.Inject

class PostDetailApiMapper @Inject constructor() : Mapper<PostItemApiResponse,PostItemApiEntity>{
    override fun mapFromApiResponse(type: PostItemApiResponse): PostItemApiEntity {
        return type.let {
            PostItemApiEntity(
                title = it.title ?: "",
                postId = it.id ?: -1
            )
        }
    }
}