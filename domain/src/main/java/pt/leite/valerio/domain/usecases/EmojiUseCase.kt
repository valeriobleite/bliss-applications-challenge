package pt.leite.valerio.domain.usecases

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository

class EmojiUseCase(private val emojiRepository: IEmojiRepository) {
    fun getEmojiList(): Single<List<EmojiEntity>> {
        return emojiRepository.getEmojiList()
    }
}