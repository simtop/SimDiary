package com.simtop.simdiary

import java.time.LocalDate
import java.util.UUID

data class Diary(
    var id: String = UUID.randomUUID().toString(),
    var title: String = "",
    var description: String = "",
    var images: List<String> = listOf(),
    var date: LocalDate = LocalDate.now()
)

