package pt.leite.valerio.blissaplicationschallenge.ui.emoji_list

import pt.leite.valerio.blissaplicationschallenge.ui.main.models.EmojiUI

data class EmojiListActivityViewState(
    val isLoading: Boolean = false,
    val emojiUIList: List<EmojiUI>? = null,
    val error: Throwable? = null
)