package pt.leite.valerio.blissapplicationschallenge.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import pt.leite.valerio.blissapplicationschallenge.ui.BlissApplication

@Module
abstract class BlissContextModule {
    @Binds
    abstract fun provideContext(application: BlissApplication): Context
}