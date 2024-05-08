package com.simtop.simdiary

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Diary(
    var id: String = UUID.randomUUID().toString(),
    var title: String = "",
    var description: String = "",
    var images: List<String> = listOf()
)

