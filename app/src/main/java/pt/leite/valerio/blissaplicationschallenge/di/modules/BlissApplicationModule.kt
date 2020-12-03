package pt.leite.valerio.blissaplicationschallenge.di.modules

import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ViewModelModule::class,
    BlissActivitiesModule::class,
    BlissHttpClientModule::class
])
class BlissApplicationModule