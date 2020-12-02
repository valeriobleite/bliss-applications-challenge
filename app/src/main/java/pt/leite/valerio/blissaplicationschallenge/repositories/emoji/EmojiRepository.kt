package pt.leite.valerio.blissaplicationschallenge.repositories.emoji

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers.EmojiContractMapper
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository

class EmojiRepository(private val client: IBlissHttpClient): IEmojiRepository {
    override fun getEmojiList(): Single<List<EmojiEntity>> {
        return client.getGithubApi().getEmojiList().map { list ->
            list.map {
                EmojiContractMapper.toEntity(it)
            }
        }
    }
}