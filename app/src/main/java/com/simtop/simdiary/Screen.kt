package com.simtop.simdiary

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()
    @Serializable
    data class Detail(val diary: Diary) : Screen() {
        companion object {
            // We need this if we want to get the content from savedInstanceState of the viewmodel
            const val navArgName = "diary"
        }
    }
}