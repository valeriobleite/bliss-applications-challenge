package pt.leite.valerio.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "avatar")
data class AvatarRoom(
    @PrimaryKey
    val login: String,
    val url: String
)