package pt.leite.valerio.blissaplicationschallenge.application

import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [BlissApplicationModule::class])
interface BlissApplicationComponent : AndroidInjector<BlissApplication> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<BlissApplication>
}
