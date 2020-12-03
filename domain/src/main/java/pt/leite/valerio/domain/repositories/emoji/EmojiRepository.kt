package pt.leite.valerio.domain.repositories.emoji

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.EmojiEntity

interface EmojiRepository {
    fun getEmojiList(): Single<List<EmojiEntity>>
}