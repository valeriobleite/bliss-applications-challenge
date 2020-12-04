package pt.leite.valerio.blissapplicationschallenge.repositories.emoji.mappers

import pt.leite.valerio.blissapplicationschallenge.repositories.BaseMapperEntityToRoom
import pt.leite.valerio.blissapplicationschallenge.repositories.BaseMapperRoomToEntity
import pt.leite.valerio.data.local.models.EmojiRoom
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiRoomMapper: BaseMapperEntityToRoom<EmojiEntity, EmojiRoom>, BaseMapperRoomToEntity<EmojiRoom, EmojiEntity> {
    override fun toRoom(entity: EmojiEntity) = EmojiRoom(url = entity.url)
    override fun toEntity(room: EmojiRoom) = EmojiEntity(room.url)
}