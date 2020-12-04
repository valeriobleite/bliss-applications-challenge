package pt.leite.valerio.blissapplicationschallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissapplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissapplicationschallenge.usecases.AvatarUseCaseModule
import pt.leite.valerio.blissapplicationschallenge.usecases.EmojiUseCaseModule

@Module(includes = [
    EmojiUseCaseModule::class,
    AvatarUseCaseModule::class,
    MainActivityModule.BindsModules::class
])
class MainActivityModule {
    @Module
    interface BindsModules {
        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

        @Binds
        fun appCompactActivity(mainActivity: MainActivity): AppCompatActivity
    }
}