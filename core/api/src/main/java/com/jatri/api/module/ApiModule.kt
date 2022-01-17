package com.jatri.api.module

import com.jatri.api.service.PostApiService
import com.jatri.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providePostApiService(
        @AppBaseUrl retrofit: Retrofit
    ):PostApiService = retrofit.create(PostApiService::class.java)
}