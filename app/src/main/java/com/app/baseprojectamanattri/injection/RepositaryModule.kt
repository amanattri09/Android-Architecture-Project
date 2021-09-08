package com.app.baseprojectamanattri.injection

import com.app.baseprojectamanattri.data.remote.post.repo.PostRepositaryImp
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositaryModule {

    @Singleton
    @Provides
    fun providesPostRepositary(postRepositaryImp: PostRepositaryImp):PostRepositary=postRepositaryImp

    }