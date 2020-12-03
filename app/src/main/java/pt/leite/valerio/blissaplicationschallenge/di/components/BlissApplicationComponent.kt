package pt.leite.valerio.blissaplicationschallenge.di.components

import dagger.Component
import dagger.android.AndroidInjector
import pt.leite.valerio.blissaplicationschallenge.ui.BlissApplication
import pt.leite.valerio.blissaplicationschallenge.di.modules.BlissApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [BlissApplicationModule::class])
interface BlissApplicationComponent : AndroidInjector<BlissApplication> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<BlissApplication>
}
