package com.example.domain.usecase

import androidx.lifecycle.LiveData
import com.jatri.entity.ApiResponse

interface BaseUseCase
interface ApiUseCase<Params, Type> : BaseUseCase {
    fun execute(params: Params? = null): LiveData<ApiResponse<Type>>
}