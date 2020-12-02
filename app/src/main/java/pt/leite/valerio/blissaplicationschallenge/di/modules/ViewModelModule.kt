package pt.leite.valerio.blissaplicationschallenge.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import pt.leite.valerio.blissaplicationschallenge.di.utils.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}