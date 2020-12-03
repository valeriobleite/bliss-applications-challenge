package pt.leite.valerio.blissaplicationschallenge.repositories.emoji

import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers.EmojiRoomMapper
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.LocalEmojiRepository

class LocalEmojiRepositoryImpl(private val database: IBlissDatabase): LocalEmojiRepository {
    override fun saveAll(emojiList: List<EmojiEntity>) {
        database.getRoom().emojiDao().insertAll(emojiList.map { EmojiRoomMapper.toRoom(it) })
    }

    override fun getAll(): List<EmojiEntity> {
        return database.getRoom().emojiDao().getAll().map { EmojiRoomMapper.toEntity(it) }
    }
}