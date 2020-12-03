package pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.EmojiRepository
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository

@Module
class EmojiRepositoryModule {
    @Provides
    fun provideEmojiRepository(client: IBlissHttpClient): IEmojiRepository = EmojiRepository(client)
}