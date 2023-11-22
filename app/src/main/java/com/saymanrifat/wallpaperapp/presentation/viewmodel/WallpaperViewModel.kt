package com.saymanrifat.wallpaperapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saymanrifat.wallpaperapp.domain.repository.WallpaperRepository
import com.saymanrifat.wallpaperapp.presentation.WallPaperUiState
import com.saymanrifat.wallpaperapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class WallpaperViewModel @Inject constructor(private val repository: WallpaperRepository) :
    ViewModel() {

    private val _wallpaperList: MutableStateFlow<WallPaperUiState> =
        MutableStateFlow(WallPaperUiState.Loading)
    val wallpaperList get() = _wallpaperList
    fun fetchWallpapers() {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getImages().collect() { resource ->
                when (resource) {
                    is Resource.Success -> {
                        if (resource.data.isNullOrEmpty().not()) {
                            _wallpaperList.update { WallPaperUiState.Success(resource.data!!) }
                        } else {
                            _wallpaperList.update { WallPaperUiState.EmptyList }
                        }
                    }

                    is Resource.Error -> {
                        _wallpaperList.update { WallPaperUiState.Error(resource.message.orEmpty()) }
                    }
                }
            }
        }
    }
}