package com.example.demoapp.di


import com.example.data.repoimpl.PostApiRepoImpl
import com.example.domain.repository.PostApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindPostApiRepository(postApiRepoImpl: PostApiRepoImpl): PostApiRepository
}