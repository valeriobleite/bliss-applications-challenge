package pt.leite.valerio.blissapplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.repositories.avatar.module.AvatarRepositoryModule
import pt.leite.valerio.domain.repositories.avatar.AvatarRepository
import pt.leite.valerio.domain.repositories.avatar.LocalAvatarRepository
import pt.leite.valerio.domain.usecases.AvatarUseCase

@Module(includes = [AvatarRepositoryModule::class])
class AvatarUseCaseModule {
    @Provides
    fun provideAvatarUseCase(avatarRepository: AvatarRepository, localAvatarRepository: LocalAvatarRepository): AvatarUseCase = AvatarUseCase(avatarRepository, localAvatarRepository)
}