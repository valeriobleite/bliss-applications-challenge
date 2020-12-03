package pt.leite.valerio.blissaplicationschallenge.ui

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import pt.leite.valerio.blissaplicationschallenge.di.modules.*

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    BlissContextModule::class,
    BlissActivitiesModule::class,
    BlissHttpClientModule::class,
    BlissDatabaseModule::class
])
class BlissApplicationModule()