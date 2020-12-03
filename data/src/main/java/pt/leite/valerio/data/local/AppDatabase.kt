package pt.leite.valerio.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pt.leite.valerio.data.local.dao.AvatarDao
import pt.leite.valerio.data.local.dao.EmojiDao
import pt.leite.valerio.data.local.models.AvatarRoom
import pt.leite.valerio.data.local.models.EmojiRoom

@Database(entities = [EmojiRoom::class, AvatarRoom::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun emojiDao(): EmojiDao
    abstract fun avatarDao(): AvatarDao
}