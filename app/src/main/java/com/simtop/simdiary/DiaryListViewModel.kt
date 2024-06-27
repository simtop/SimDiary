package com.simtop.simdiary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.toRoute
import kotlin.reflect.typeOf

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
        val detailArgs: Screen.Detail = savedStateHandle.toRoute<Screen.Detail>(
            typeMap = mapOf(
                typeOf<Diary>() to NavType.fromParcelable<Diary>()
            )
        )
        uiState = uiState.copy(
            selectedDiaryId = detailArgs.diary.id
        )
    }

}

data class UiState(
    val selectedDiaryId: String? = null,
)
