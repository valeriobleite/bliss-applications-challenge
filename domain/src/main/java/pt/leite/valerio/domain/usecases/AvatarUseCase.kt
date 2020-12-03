package pt.leite.valerio.domain.usecases

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.AvatarEntity
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository

class AvatarUseCase(
    private val avatarRepository: AvatarRepository
) {
    fun getAvatar(login: String): Single<AvatarEntity> {
        return avatarRepository.getAvatar(login)
    }
}