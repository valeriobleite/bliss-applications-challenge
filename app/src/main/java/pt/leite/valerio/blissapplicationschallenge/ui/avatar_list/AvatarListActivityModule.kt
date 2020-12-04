package pt.leite.valerio.blissapplicationschallenge.ui.avatar_list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissapplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissapplicationschallenge.usecases.AvatarUseCaseModule

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