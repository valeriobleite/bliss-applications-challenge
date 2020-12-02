package pt.leite.valerio.blissaplicationschallenge.ui.main

import androidx.lifecycle.ViewModel
import pt.leite.valerio.domain.usecases.EmojiUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val emojiUseCase: EmojiUseCase): ViewModel() {
}