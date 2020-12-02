package pt.leite.valerio.blissaplicationschallenge.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pt.leite.valerio.blissaplicationschallenge.ui.main.MainActivity
import pt.leite.valerio.blissaplicationschallenge.ui.main.MainActivityModule

@Module

abstract class BlissActivitiesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivityInjector(): MainActivity
}