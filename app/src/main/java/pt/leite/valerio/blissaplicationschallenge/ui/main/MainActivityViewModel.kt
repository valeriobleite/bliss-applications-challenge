package pt.leite.valerio.blissaplicationschallenge.ui.main

import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseViewModel
import pt.leite.valerio.blissaplicationschallenge.ui.main.mappers.AvatarUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.main.mappers.EmojiUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.EmojiUI
import pt.leite.valerio.domain.usecases.AvatarUseCase
import pt.leite.valerio.domain.usecases.EmojiUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val emojiUseCase: EmojiUseCase,
    private val avatarUseCase: AvatarUseCase
) : BlissBaseViewModel<MainActivityViewState, MainActivityIntent>() {

    init {
        viewState = MainActivityViewState()
    }

    override fun process(intent: MainActivityIntent) {
        when(intent) {
            MainActivityIntent.RandomIntent -> random()
            is MainActivityIntent.SearchIntent -> search(intent.name)
        }
    }

    private fun random() {
        callSingle(
            emojiUseCase.getRandomEmoji(),
            onLoading = { updateEmoji(true, null, null) },
            onSuccess = { updateEmoji(false, EmojiUIMapper.toUI(it), null) },
            onError = { updateEmoji(false, null, it) }
        )
    }

    private fun search(name: String) {
        callSingle(
            avatarUseCase.getAvatar(name),
            onLoading = { updateAvatar(true, null, null) },
            onSuccess = { updateAvatar(false, AvatarUIMapper.toUI(it), null) },
            onError = { updateAvatar(false, null, it) }
        )
    }

    private fun updateEmoji(isLoading: Boolean, emojiUI: EmojiUI?, error: Throwable?) {
        postValue(
            viewState.copy(
                emojiViewState = viewState.emojiViewState.copy(
                    isLoading = isLoading,
                    emojiUI = emojiUI,
                    error = error
                )
            )
        )
    }

    private fun updateAvatar(isLoading: Boolean, avatarUI: AvatarUI?, error: Throwable?) {
        postValue(
            viewState.copy(
                avatarViewState = viewState.avatarViewState.copy(
                    isLoading = isLoading,
                    avatarUI = avatarUI,
                    error = error
                )
            )
        )
    }
}
