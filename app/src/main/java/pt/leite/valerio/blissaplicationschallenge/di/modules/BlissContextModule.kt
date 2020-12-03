package pt.leite.valerio.blissaplicationschallenge.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import pt.leite.valerio.blissaplicationschallenge.ui.BlissApplication

@Module
abstract class BlissContextModule {
    @Binds
    abstract fun provideContext(application: BlissApplication): Context
}