package pt.leite.valerio.blissapplicationschallenge.repositories.emoji.mappers

import pt.leite.valerio.blissapplicationschallenge.repositories.BaseMapperContractToEntity
import pt.leite.valerio.data.remote.response.EmojiResponse
import pt.leite.valerio.domain.entities.EmojiEntity

object EmojiContractMapper: BaseMapperContractToEntity<EmojiResponse, List<EmojiEntity>> {
    override fun toEntity(contract: EmojiResponse) = contract.emojiList.map {
        EmojiEntity(it.url)
    }
}