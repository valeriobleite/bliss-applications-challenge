package pt.leite.valerio.blissaplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.avatar.module.AvatarRepositoryModule
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository
import pt.leite.valerio.domain.usecases.AvatarUseCase

@Module(includes = [AvatarRepositoryModule::class])
class AvatarUseCaseModule {
    @Provides
    fun provideAvatarUseCase(avatarRepository: AvatarRepository): AvatarUseCase = AvatarUseCase(avatarRepository)
}