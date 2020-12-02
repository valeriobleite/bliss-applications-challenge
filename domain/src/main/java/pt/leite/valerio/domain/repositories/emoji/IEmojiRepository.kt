package pt.leite.valerio.domain.repositories.emoji

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.EmojiEntity

interface IEmojiRepository {
    fun getEmojiList(): Single<List<EmojiEntity>>
}