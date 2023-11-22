package com.saymanrifat.wallpaperapp.presentation

import com.saymanrifat.wallpaperapp.domain.entity.WallpaperLinks


sealed class WallPaperUiState{
    object Loading : WallPaperUiState()
    object EmptyList : WallPaperUiState()
    data class Success(val data: List<WallpaperLinks>) : WallPaperUiState()
    data class Error(val message:String) : WallPaperUiState()

}