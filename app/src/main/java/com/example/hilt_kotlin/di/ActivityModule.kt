package com.example.hilt_kotlin.di

import com.example.hilt_kotlin.di.qualifier.ActivityHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

// 11. 두 개의 모듈 생성해 원하는 모듈을 구분해보기 위해 생성
@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityHash
    @Provides
    fun provideHash() = hashCode().toString()
}