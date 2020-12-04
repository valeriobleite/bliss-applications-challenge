package pt.leite.valerio.blissapplicationschallenge.ui.emoji_list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissapplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissapplicationschallenge.usecases.EmojiUseCaseModule

@Module(includes = [
    EmojiUseCaseModule::class,
    EmojiListActivityModule.BindsModules::class
])
class EmojiListActivityModule {
    @Module
    interface BindsModules {
        @Binds
        @IntoMap
        @ViewModelKey(EmojiListActivityViewModel::class)
        fun bindEmojiListActivityViewModel(viewModel: EmojiListActivityViewModel): ViewModel

        @Binds
        fun appCompactActivity(EmojiListActivity: EmojiListActivity): AppCompatActivity
    }
}