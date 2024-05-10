package com.simtop.simdiary

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.toRoute
import com.simtop.simdiary.Constants.DETAIL_SCREEN_ARGUMENT_KEY

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
        val data: Diary = savedStateHandle.toRoute()
        uiState = uiState.copy(
            selectedDiaryId = data.id
        )
    }

}

data class UiState(
    val selectedDiaryId: String? = null,
    val selectedDiary: Diary? = Diary(title = "no funciono"),
    val title: String = "",
    val description: String = "",
)
