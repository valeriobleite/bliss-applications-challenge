package pt.leite.valerio.blissaplicationschallenge.repositories.avatar

import pt.leite.valerio.blissaplicationschallenge.repositories.avatar.mappers.AvatarRoomMapper
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.domain.entities.AvatarEntity
import pt.leite.valerio.domain.repositories.avatar.LocalAvatarRepository

class LocalAvatarRepositoryImpl(private val database: IBlissDatabase): LocalAvatarRepository {
    override fun save(avatar: AvatarEntity) {
        database.getRoom().avatarDao().insert(AvatarRoomMapper.toRoom(avatar))
    }

    override fun delete(avatar: AvatarEntity) {
        database.getRoom().avatarDao().delete(AvatarRoomMapper.toRoom(avatar))
    }

    override fun get(login: String): AvatarEntity? {
        database.getRoom().avatarDao().get(login)?.let {
            return AvatarRoomMapper.toEntity(it)
        }

        return null
    }

    override fun getAll(): List<AvatarEntity> {
        return database.getRoom().avatarDao().getAll().map { AvatarRoomMapper.toEntity(it) }
    }
}