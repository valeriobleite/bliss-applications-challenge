package pt.leite.valerio.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emoji")
data class EmojiRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val url: String
)