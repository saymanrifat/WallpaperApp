package com.saymanrifat.wallpaperapp.data.api

import com.saymanrifat.wallpaperapp.data.api.model.PicSumItem
import com.saymanrifat.wallpaperapp.utils.Constants.BASE_URL
import com.saymanrifat.wallpaperapp.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query


interface PicSumApi {
    @GET(BASE_URL + END_POINT)
    fun getWallpaperImages(
        @Query("page") page: Int = 1, @Query("limit") limit: Int = 100
    ): List<PicSumItem>?
}