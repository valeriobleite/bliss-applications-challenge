package pt.leite.valerio.blissapplicationschallenge.di.components

import dagger.Component
import dagger.android.AndroidInjector
import pt.leite.valerio.blissapplicationschallenge.ui.BlissApplication
import pt.leite.valerio.blissapplicationschallenge.ui.BlissApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [BlissApplicationModule::class])
interface BlissApplicationComponent : AndroidInjector<BlissApplication> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<BlissApplication>
}
