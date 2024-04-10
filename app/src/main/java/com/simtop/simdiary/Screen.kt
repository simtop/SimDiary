package com.simtop.simdiary

import com.simtop.simdiary.Constants.DETAIL_SCREEN_ARGUMENT_KEY
import com.simtop.simdiary.Constants.DETAIL_SCREEN_PAGE
import com.simtop.simdiary.Constants.HOME_SCREEN_PAGE


sealed class Screen(val route: String) {
    object Home : Screen(route = HOME_SCREEN_PAGE)
    object Detail : Screen(route = "$DETAIL_SCREEN_PAGE?$DETAIL_SCREEN_ARGUMENT_KEY=" +
            "{$DETAIL_SCREEN_ARGUMENT_KEY}") {
        fun passDiaryId(diaryId: String) =
            "$DETAIL_SCREEN_PAGE?$DETAIL_SCREEN_ARGUMENT_KEY=$diaryId"
    }
}