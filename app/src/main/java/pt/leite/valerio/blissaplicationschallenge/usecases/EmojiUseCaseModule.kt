package pt.leite.valerio.blissaplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.mappers.EmojiRepositoryModule
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository
import pt.leite.valerio.domain.usecases.EmojiUseCase

@Module(includes = [EmojiRepositoryModule::class])
class EmojiUseCaseModule {
    @Provides
    fun provideEmojiUseCase(emojiRepository: IEmojiRepository): EmojiUseCase = EmojiUseCase(emojiRepository)
}