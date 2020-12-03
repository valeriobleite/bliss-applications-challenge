package pt.leite.valerio.blissaplicationschallenge.ui.emoji_list

import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseViewModel
import pt.leite.valerio.blissaplicationschallenge.ui.main.mappers.EmojiUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.EmojiUI
import pt.leite.valerio.domain.usecases.EmojiUseCase
import javax.inject.Inject

class EmojiListActivityViewModel @Inject constructor(private val emojiUseCase: EmojiUseCase): BlissBaseViewModel<EmojiListActivityViewState, EmojiListActivityIntent>() {

    init {
        viewState = EmojiListActivityViewState()
    }

    override fun process(intent: EmojiListActivityIntent) {
        when(intent) {
            EmojiListActivityIntent.LoadListIntent -> getList()
        }
    }

    private fun getList() {
        callSingle(
            emojiUseCase.getEmojiList(),
            onLoading = { updateEmoji(true, null, null) },
            onSuccess = { list -> updateEmoji(false, list.map { EmojiUIMapper.toUI(it) }, null) },
            onError = { updateEmoji(false, null, it) }
        )
    }

    private fun updateEmoji(isLoading: Boolean, emojiUIList: List<EmojiUI>?, error: Throwable?) {
        postValue(
            viewState.copy(
                isLoading = isLoading,
                emojiUIList = emojiUIList,
                error = error
            )
        )
    }
}
