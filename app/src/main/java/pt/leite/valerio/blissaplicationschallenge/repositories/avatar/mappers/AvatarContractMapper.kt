package pt.leite.valerio.blissaplicationschallenge.repositories.avatar.mappers

import pt.leite.valerio.blissaplicationschallenge.repositories.BaseMapperContractToEntity
import pt.leite.valerio.data.remote.response.AvatarResponse
import pt.leite.valerio.domain.entities.AvatarEntity

object AvatarContractMapper: BaseMapperContractToEntity<AvatarResponse, AvatarEntity> {
    override fun toEntity(contract: AvatarResponse) = AvatarEntity(
        login = contract.login!!,
        url = contract.avatarUrl!!
    )
}