package pt.leite.valerio.domain.usecases

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.AvatarEntity
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository
import pt.leite.valerio.domain.repositories.avatar.LocalAvatarRepository

class AvatarUseCase(
    private val avatarRepository: AvatarRepository,
    private val localAvatarRepository: LocalAvatarRepository
) {
    fun getAvatar(login: String): Single<AvatarEntity> {
        val avatar = localAvatarRepository.get(login)

        avatar?.let {
            return Single.just(it)
        }

        return avatarRepository.getAvatar(login).map {
            localAvatarRepository.save(it)
            it
        }
    }

    fun getAvatarList(): Single<List<AvatarEntity>> = Single.just(localAvatarRepository.getAll())
}