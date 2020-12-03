package pt.leite.valerio.blissaplicationschallenge.repositories.emoji.module

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.EmojiRepositoryImpl
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.LocalEmojiRepositoryImpl
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository
import pt.leite.valerio.domain.repositories.emoji.ILocalEmojiRepository

@Module
class EmojiRepositoryModule {
    @Provides
    fun provideEmojiRepository(client: IBlissHttpClient): IEmojiRepository = EmojiRepositoryImpl(client)

    @Provides
    fun provideLocalEmojiRepository(database: IBlissDatabase): ILocalEmojiRepository = LocalEmojiRepositoryImpl(database)
}