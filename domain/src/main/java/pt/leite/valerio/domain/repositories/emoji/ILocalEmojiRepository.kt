package pt.leite.valerio.domain.repositories.emoji

import pt.leite.valerio.domain.entities.EmojiEntity

interface ILocalEmojiRepository {
    fun saveAll(emojiList: List<EmojiEntity>)
}