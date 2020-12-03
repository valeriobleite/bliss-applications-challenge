package pt.leite.valerio.domain.repositories.avatar

import pt.leite.valerio.domain.entities.AvatarEntity

interface LocalAvatarRepository {
    fun save(avatar: AvatarEntity)
    fun delete(avatar: AvatarEntity)
    fun get(login: String): AvatarEntity?
    fun getAll(): List<AvatarEntity>
}