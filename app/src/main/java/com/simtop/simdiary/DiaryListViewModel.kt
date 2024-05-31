package com.simtop.simdiary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute

class DiaryListViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {
    var uiState by mutableStateOf(UiState())
        private set

    init {
        getDiaryIdArgument()
    }

    private fun getDiaryIdArgument() {
        val data: Screen.Detail = savedStateHandle.toRoute()
        uiState = uiState.copy(
            selectedDiaryId = data.id
        )
    }

}

data class UiState(
    val selectedDiaryId: String? = null,
)
