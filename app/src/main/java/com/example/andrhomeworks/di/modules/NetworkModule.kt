package com.example.andrhomeworks.di.modules

import com.example.andrhomeworks.data.network.Api
import com.example.andrhomeworks.di.annotations.ApiWithInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @ApiWithInterceptor
    fun provideApiWithInterceptor(
        retrofit: Retrofit
    ): Api{
        return retrofit.create(Api::class.java)
    }


}