package com.saymanrifat.wallpaperapp.data.api


import com.saymanrifat.wallpaperapp.domain.entity.WallpaperLinks
import com.saymanrifat.wallpaperapp.domain.repository.WallpaperRepository
import com.saymanrifat.wallpaperapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class WallpaperRepositoryImpl @Inject constructor(val picSumApi: PicSumApi) : WallpaperRepository {
    override fun getImages(): Flow<Resource<List<WallpaperLinks>>> = flow {

        try {
            val response = picSumApi.getWallpaperImages()
            response?.let {
                val wallpaperLinks: List<WallpaperLinks> =
                    it.map { WallpaperLinks(it.downloadUrl) }
                emit(Resource.Success(wallpaperLinks))
            }
        } catch (e: IOException) {
            emit(Resource.Error(data = null, message = e.message.toString()))
        }

    }

}