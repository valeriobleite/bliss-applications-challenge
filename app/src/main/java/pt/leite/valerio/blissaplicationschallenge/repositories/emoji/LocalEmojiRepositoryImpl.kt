package pt.leite.valerio.blissaplicationschallenge.repositories.emoji

import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers.EmojiRoomMapper
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.ILocalEmojiRepository

class LocalEmojiRepositoryImpl(private val database: IBlissDatabase): ILocalEmojiRepository {
    override fun saveAll(emojiList: List<EmojiEntity>) {
        database.getRoom().emojiDao().insertAll(emojiList.map { EmojiRoomMapper.toRoom(it) })
    }
}