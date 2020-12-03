package pt.leite.valerio.blissaplicationschallenge.ui.main

import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseViewModel
import pt.leite.valerio.blissaplicationschallenge.ui.main.mappers.EmojiUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.EmojiUI
import pt.leite.valerio.domain.usecases.EmojiUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val emojiUseCase: EmojiUseCase): BlissBaseViewModel<MainActivityViewModel.ViewState, MainActivityViewModel.Intent>() {

    init {
        viewState = ViewState()
    }

    override fun process(intent: Intent) {
        when(intent) {
            Intent.RandomIntent -> random()
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

    private fun updateEmoji(isLoading: Boolean, emojiUI: EmojiUI?, error: Throwable?) {
        postValue(
            viewState.copy(
                isLoading = isLoading,
                emojiUI = emojiUI,
                error = error
            )
        )
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val emojiUI: EmojiUI? = null,
        val error: Throwable? = null
    )

    sealed class Intent {
        object RandomIntent: Intent()
    }
}
