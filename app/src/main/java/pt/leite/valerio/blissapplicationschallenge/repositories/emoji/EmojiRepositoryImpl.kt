package pt.leite.valerio.blissapplicationschallenge.repositories.emoji

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.blissapplicationschallenge.repositories.emoji.mappers.EmojiContractMapper
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.EmojiRepository

class EmojiRepositoryImpl(private val client: IBlissHttpClient): EmojiRepository {
    override fun getEmojiList(): Single<List<EmojiEntity>> {
        return client.getGithubApi().getEmojiList().map {
            EmojiContractMapper.toEntity(it)
        }
    }
}