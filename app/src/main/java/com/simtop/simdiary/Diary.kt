package com.simtop.simdiary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.util.UUID

@Parcelize
data class Diary(
    var id: String = UUID.randomUUID().toString(),
    var title: String = "",
    var description: String = "",
    var images: List<String> = listOf(),
    var date: LocalDate = LocalDate.now()
): Parcelable