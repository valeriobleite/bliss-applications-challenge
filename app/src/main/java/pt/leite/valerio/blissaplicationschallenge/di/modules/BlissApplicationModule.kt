package pt.leite.valerio.blissaplicationschallenge.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import pt.leite.valerio.blissaplicationschallenge.ui.BlissApplication
import javax.inject.Singleton

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    BlissContextModule::class,
    BlissActivitiesModule::class,
    BlissHttpClientModule::class,
    BlissDatabaseModule::class
])
class BlissApplicationModule()