package pt.leite.valerio.blissaplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.module.EmojiRepositoryModule
import pt.leite.valerio.domain.repositories.emoji.EmojiRepository
import pt.leite.valerio.domain.repositories.emoji.LocalEmojiRepository
import pt.leite.valerio.domain.usecases.EmojiUseCase

@Module(includes = [EmojiRepositoryModule::class])
class EmojiUseCaseModule {
    @Provides
    fun provideEmojiUseCase(emojiRepository: EmojiRepository, localEmojiRepository: LocalEmojiRepository): EmojiUseCase = EmojiUseCase(emojiRepository, localEmojiRepository)
}