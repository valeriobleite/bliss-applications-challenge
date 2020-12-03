package pt.leite.valerio.blissaplicationschallenge.ui.main

import pt.leite.valerio.blissaplicationschallenge.ui.main.models.EmojiUI

data class MainActivityViewState(
    val isLoading: Boolean = false,
    val emojiUI: EmojiUI? = null,
    val error: Throwable? = null
)