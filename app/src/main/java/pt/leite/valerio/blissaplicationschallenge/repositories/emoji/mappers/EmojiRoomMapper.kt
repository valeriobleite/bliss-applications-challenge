package pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers

import pt.leite.valerio.blissaplicationschallenge.repositories.BaseMapperEntityToRoom
import pt.leite.valerio.blissaplicationschallenge.repositories.BaseMapperRoomToEntity
import pt.leite.valerio.data.local.models.EmojiRoom
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiRoomMapper: BaseMapperEntityToRoom<EmojiEntity, EmojiRoom>, BaseMapperRoomToEntity<EmojiRoom, EmojiEntity> {
    override fun toRoom(entity: EmojiEntity) = EmojiRoom(url = entity.url)

    override fun toEntity(room: EmojiRoom) = EmojiEntity(room.url)
}