package com.saymanrifat.wallpaperapp.di

import com.saymanrifat.wallpaperapp.data.api.PicSumApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofitApi(
    ): PicSumApi {
        return Retrofit.Builder()
            .build()
            .create(PicSumApi::class.java)
    }
}