package pt.leite.valerio.blissapplicationschallenge.ui.main.mappers

import pt.leite.valerio.blissapplicationschallenge.ui.base.BaseMapperEntityToUI
import pt.leite.valerio.blissapplicationschallenge.ui.main.models.EmojiUI
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiUIMapper: BaseMapperEntityToUI<EmojiEntity, EmojiUI> {
    override fun toUI(entity: EmojiEntity) = EmojiUI(entity.url)
}