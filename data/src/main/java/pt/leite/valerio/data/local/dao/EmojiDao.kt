package pt.leite.valerio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pt.leite.valerio.data.local.models.EmojiRoom

@Dao
interface EmojiDao {
    @Query("SELECT * FROM emoji")
    fun getAll(): List<EmojiRoom>

    @Insert
    fun insertAll(emojiList: List<EmojiRoom>)
}