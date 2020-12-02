package pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers

import pt.leite.valerio.blissaplicationschallenge.repositories.BaseMapperContractToEntity
import pt.leite.valerio.data.remote.contracts.EmojiResponseContract
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiContractMapper: BaseMapperContractToEntity<EmojiResponseContract, EmojiEntity> {
    override fun toEntity(contract: EmojiResponseContract) = EmojiEntity(
        url = contract.url
    )
}