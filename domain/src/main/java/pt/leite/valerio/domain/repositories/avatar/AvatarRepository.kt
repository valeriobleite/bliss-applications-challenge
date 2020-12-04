package pt.leite.valerio.domain.repositories.avatar

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.AvatarEntity

interface AvatarRepository {
    fun getAvatar(login: String): Single<AvatarEntity>
}