package com.simtop.simdiary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.UUID

@Serializable
@Parcelize
data class Diary(
    var id: String = UUID.randomUUID().toString(),
    var title: String = "",
    var description: String = "",
    var images: List<String> = listOf(),
    @Serializable(with = LocalDateSerializer::class)
    var date: LocalDate = LocalDate.now()
): Parcelable

