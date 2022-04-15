package com.storesoko.rickmortyapp.Network.models

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)