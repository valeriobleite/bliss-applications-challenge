package pt.leite.valerio.blissaplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.emoji.module.EmojiRepositoryModule
import pt.leite.valerio.domain.repositories.emoji.IEmojiRepository
import pt.leite.valerio.domain.repositories.emoji.ILocalEmojiRepository
import pt.leite.valerio.domain.usecases.EmojiUseCase

@Module(includes = [EmojiRepositoryModule::class])
class EmojiUseCaseModule {
    @Provides
    fun provideEmojiUseCase(emojiRepository: IEmojiRepository, localEmojiRepository: ILocalEmojiRepository): EmojiUseCase = EmojiUseCase(emojiRepository, localEmojiRepository)
}