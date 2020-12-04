package pt.leite.valerio.blissapplicationschallenge.repositories.avatar.module

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.repositories.avatar.AvatarRepositoryImpl
import pt.leite.valerio.blissapplicationschallenge.repositories.avatar.LocalAvatarRepositoryImpl
import pt.leite.valerio.data.local.IBlissDatabase
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository
import pt.leite.valerio.domain.repositories.avatar.LocalAvatarRepository

@Module
class AvatarRepositoryModule {
    @Provides
    fun provideAvatarRepository(client: IBlissHttpClient): AvatarRepository = AvatarRepositoryImpl(client)

    @Provides
    fun provideLocalAvatarRepository(database: IBlissDatabase): LocalAvatarRepository = LocalAvatarRepositoryImpl(database)
}