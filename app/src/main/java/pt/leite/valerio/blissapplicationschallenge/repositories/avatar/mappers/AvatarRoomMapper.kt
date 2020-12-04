package pt.leite.valerio.blissapplicationschallenge.repositories.avatar.mappers

import pt.leite.valerio.blissapplicationschallenge.repositories.BaseMapperEntityToRoom
import pt.leite.valerio.blissapplicationschallenge.repositories.BaseMapperRoomToEntity
import pt.leite.valerio.data.local.models.AvatarRoom
import pt.leite.valerio.domain.entities.AvatarEntity

object AvatarRoomMapper: BaseMapperEntityToRoom<AvatarEntity, AvatarRoom>, BaseMapperRoomToEntity<AvatarRoom, AvatarEntity> {
    override fun toRoom(entity: AvatarEntity) = AvatarRoom(login = entity.login, url = entity.url)
    override fun toEntity(room: AvatarRoom) = AvatarEntity(login = room.login, url = room.url)
}