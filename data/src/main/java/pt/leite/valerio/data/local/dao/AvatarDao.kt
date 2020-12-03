package pt.leite.valerio.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pt.leite.valerio.data.local.models.AvatarRoom

@Dao
interface AvatarDao {
    @Query("SELECT * FROM avatar")
    fun getAll(): List<AvatarRoom>

    @Query("SELECT * FROM avatar WHERE login = :login")
    fun get(login: String): AvatarRoom?

    @Insert
    fun insert(avatar: AvatarRoom)
    
    @Delete
    fun delete(avatar: AvatarRoom)
}