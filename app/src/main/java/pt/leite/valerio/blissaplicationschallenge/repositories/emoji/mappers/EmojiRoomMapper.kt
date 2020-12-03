package pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers

import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.BaseMapperEntityToRoom
import pt.leite.valerio.data.local.models.EmojiRoom
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiRoomMapper: BaseMapperEntityToRoom<EmojiEntity, EmojiRoom> {
    override fun toRoom(entity: EmojiEntity) = EmojiRoom(url = entity.url)
}