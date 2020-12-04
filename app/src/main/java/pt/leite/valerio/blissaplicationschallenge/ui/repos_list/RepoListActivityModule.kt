package pt.leite.valerio.blissaplicationschallenge.ui.repos_list

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pt.leite.valerio.blissaplicationschallenge.di.utils.ViewModelKey
import pt.leite.valerio.blissaplicationschallenge.usecases.RepoUseCaseModule

@Module(includes = [
    RepoUseCaseModule::class,
    RepoListActivityModule.BindsModules::class
])
class RepoListActivityModule {
    @Module
    interface BindsModules {
        @Binds
        @IntoMap
        @ViewModelKey(RepoListActivityViewModel::class)
        fun bindRepoListActivityViewModel(viewModel: RepoListActivityViewModel): ViewModel

        @Binds
        fun appCompactActivity(RepoListActivity: RepoListActivity): AppCompatActivity
    }
}