package br.com.fiap.ecoimpact.model

data class ActionItem(
    val name: String,
    val co2: Double,
    val emoji: String,
    val selected: Boolean = false
)