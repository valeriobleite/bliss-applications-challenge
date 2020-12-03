package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissaplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissaplicationschallenge.usecases.AvatarUseCaseModule

@Module(includes = [
    AvatarUseCaseModule::class,
    AvatarListActivityModule.BindsModules::class
])
class AvatarListActivityModule {
    @Module
    interface BindsModules {
        @Binds
        @IntoMap
        @ViewModelKey(AvatarListActivityViewModel::class)
        fun bindAvatarListActivityViewModel(viewModel: AvatarListActivityViewModel): ViewModel

        @Binds
        fun appCompactActivity(AvatarListActivity: AvatarListActivity): AppCompatActivity
    }
}