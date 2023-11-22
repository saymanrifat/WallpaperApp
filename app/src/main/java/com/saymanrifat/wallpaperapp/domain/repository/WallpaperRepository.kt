package com.saymanrifat.wallpaperapp.domain.repository


import com.saymanrifat.wallpaperapp.domain.entity.WallpaperLinks
import com.saymanrifat.wallpaperapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    fun getImages() : Flow<Resource<List<WallpaperLinks>>>
}