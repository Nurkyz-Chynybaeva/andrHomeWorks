package com.example.andrhomeworks.di.modules

import android.util.Log
import com.example.andrhomeworks.BuildConfig
import com.example.andrhomeworks.data.network.Api
import com.example.andrhomeworks.di.annotations.ApiWithInterceptor
import com.example.andrhomeworks.di.annotations.ApiWithoutInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @ApiWithInterceptor
    fun provideApiWithInterceptor(
        okHttpClient: OkHttpClient,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @ApiWithoutInterceptor
    fun provideApiWithoutInterceptor(): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(300L, TimeUnit.SECONDS)
            .readTimeout(300L, TimeUnit.SECONDS)
            .writeTimeout(300L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("OkHttp_body", message)
            }
        }).setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE)
    }

    companion object {
        const val BASE_URL = "https://breakingbadapi.com"
    }
}