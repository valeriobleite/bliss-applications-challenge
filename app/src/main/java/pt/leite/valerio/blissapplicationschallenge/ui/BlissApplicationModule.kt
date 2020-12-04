package pt.leite.valerio.blissapplicationschallenge.ui

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import pt.leite.valerio.blissapplicationschallenge.di.modules.*

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    BlissContextModule::class,
    BlissActivitiesModule::class,
    BlissHttpClientModule::class,
    BlissDatabaseModule::class
])
class BlissApplicationModule()