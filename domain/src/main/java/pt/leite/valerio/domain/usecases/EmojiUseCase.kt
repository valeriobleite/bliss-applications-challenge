package pt.leite.valerio.domain.usecases

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository
import pt.leite.valerio.domain.repositories.emoji.ILocalEmojiRepository

class EmojiUseCase(
    private val emojiRepository: IEmojiRepository,
    private val localEmojiRepository: ILocalEmojiRepository
) {
    fun getRandomEmoji(): Single<EmojiEntity> {
        return getEmojiList().map {
            it.random()
        }
    }

    fun getEmojiList(): Single<List<EmojiEntity>> {
        val emojiList = localEmojiRepository.getAll()

        return if (emojiList.isEmpty()) {
            emojiRepository.getEmojiList().map {
                localEmojiRepository.saveAll(it)
                it
            }
        } else {
            Single.just(emojiList)
        }
    }
}