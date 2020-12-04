package pt.leite.valerio.data.local

import android.content.Context
import androidx.room.Room

class BlissDatabaseImpl(context: Context, val name: String): IBlissDatabase {
    private val room: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, name).allowMainThreadQueries().build()
    override fun getRoom() = room
}