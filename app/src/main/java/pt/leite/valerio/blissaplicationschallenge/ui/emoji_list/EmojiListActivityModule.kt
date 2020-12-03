package pt.leite.valerio.blissaplicationschallenge.ui.emoji_list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissaplicationschallenge.di.modules.ViewModelModule
import pt.leite.valerio.blissaplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissaplicationschallenge.usecases.EmojiUseCaseModule

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