package pt.leite.valerio.blissapplicationschallenge.ui.repos_list.mappers

import pt.leite.valerio.blissapplicationschallenge.ui.base.BaseMapperEntityToUI
import pt.leite.valerio.blissapplicationschallenge.ui.repos_list.models.RepoUI
import pt.leite.valerio.domain.entities.RepoEntity

object RepoUIMapper: BaseMapperEntityToUI<RepoEntity, RepoUI> {
    override fun toUI(entity: RepoEntity) = RepoUI(entity.name)
}