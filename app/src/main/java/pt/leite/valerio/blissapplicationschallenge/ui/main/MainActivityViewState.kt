package pt.leite.valerio.blissapplicationschallenge.ui.main

import pt.leite.valerio.blissapplicationschallenge.ui.main.models.AvatarUI
import pt.leite.valerio.blissapplicationschallenge.ui.main.models.EmojiUI

data class MainActivityViewState(
    val emojiViewState: EmojiViewState = EmojiViewState(),
    val avatarViewState: AvatarViewState = AvatarViewState(),
) {
    data class EmojiViewState(
        val isLoading: Boolean = false,
        val emojiUI: EmojiUI? = null,
        val error: Throwable? = null
    )

    data class AvatarViewState(
        val isLoading: Boolean = false,
        val avatarUI: AvatarUI? = null,
        val error: Throwable? = null
    )
}