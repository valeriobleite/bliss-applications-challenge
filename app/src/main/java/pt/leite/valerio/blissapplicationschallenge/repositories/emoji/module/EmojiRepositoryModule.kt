package pt.leite.valerio.blissapplicationschallenge.repositories.emoji.module

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.repositories.emoji.EmojiRepositoryImpl
import pt.leite.valerio.blissapplicationschallenge.repositories.emoji.LocalEmojiRepositoryImpl
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.emoji.EmojiRepository
import pt.leite.valerio.domain.repositories.emoji.LocalEmojiRepository

@Module
class EmojiRepositoryModule {
    @Provides
    fun provideEmojiRepository(client: IBlissHttpClient): EmojiRepository = EmojiRepositoryImpl(client)

    @Provides
    fun provideLocalEmojiRepository(database: IBlissDatabase): LocalEmojiRepository = LocalEmojiRepositoryImpl(database)
}