package pt.leite.valerio.blissaplicationschallenge.ui.main

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