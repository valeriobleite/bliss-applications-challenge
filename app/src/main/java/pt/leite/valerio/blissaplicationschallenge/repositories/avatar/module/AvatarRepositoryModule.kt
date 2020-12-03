package pt.leite.valerio.blissaplicationschallenge.repositories.avatar.module

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.avatar.AvatarRepositoryImpl
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository

@Module
class AvatarRepositoryModule {
    @Provides
    fun provideAvatarRepository(client: IBlissHttpClient): AvatarRepository = AvatarRepositoryImpl(client)
}