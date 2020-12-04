package pt.leite.valerio.blissapplicationschallenge.repositories.avatar

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.blissapplicationschallenge.repositories.avatar.mappers.AvatarContractMapper
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.entities.AvatarEntity
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository

class AvatarRepositoryImpl(private val client: IBlissHttpClient): AvatarRepository {
    override fun getAvatar(login: String): Single<AvatarEntity> {
        return client.getGithubApi().getAvatar(login).map {
            AvatarContractMapper.toEntity(it)
        }
    }
}