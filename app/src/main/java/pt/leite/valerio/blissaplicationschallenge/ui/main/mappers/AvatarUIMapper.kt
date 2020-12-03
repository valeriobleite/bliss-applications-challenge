package pt.leite.valerio.blissaplicationschallenge.ui.main.mappers

import pt.leite.valerio.blissaplicationschallenge.ui.base.BaseMapperEntityToUI
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI
import pt.leite.valerio.domain.entities.AvatarEntity

object AvatarUIMapper: BaseMapperEntityToUI<AvatarEntity, AvatarUI> {
    override fun toUI(entity: AvatarEntity) = AvatarUI(entity.url)
}