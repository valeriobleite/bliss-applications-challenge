package pt.leite.valerio.blissapplicationschallenge.ui.emoji_list

import pt.leite.valerio.blissapplicationschallenge.ui.main.models.EmojiUI

data class EmojiListActivityViewState(
    val isLoading: Boolean = false,
    val emojiUIList: List<EmojiUI>? = null,
    val error: Throwable? = null
)