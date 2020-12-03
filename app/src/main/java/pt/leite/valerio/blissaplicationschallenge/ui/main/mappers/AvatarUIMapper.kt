package pt.leite.valerio.blissaplicationschallenge.ui.main.mappers

import pt.leite.valerio.blissaplicationschallenge.ui.base.BaseMapperEntityToUI
import pt.leite.valerio.blissaplicationschallenge.ui.base.BaseMapperUIToEntity
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI
import pt.leite.valerio.domain.entities.AvatarEntity

object AvatarUIMapper: BaseMapperEntityToUI<AvatarEntity, AvatarUI>, BaseMapperUIToEntity<AvatarUI, AvatarEntity> {
    override fun toUI(entity: AvatarEntity) = AvatarUI(login = entity.login, url = entity.url)
    override fun toEntity(ui: AvatarUI) = AvatarEntity(login = ui.login, url = ui.url)
}