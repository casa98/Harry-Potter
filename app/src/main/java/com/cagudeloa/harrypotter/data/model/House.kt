package com.cagudeloa.harrypotter.data.model

data class House (
    val name: String,
    val animal: String,
    val element: String,
    val founder: String,
    val ghost: String,
    val common_room: String,
    val values:  List<String>,
    val colors: List<String>
)