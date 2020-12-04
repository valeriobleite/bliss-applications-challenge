package pt.leite.valerio.blissapplicationschallenge.ui

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pt.leite.valerio.blissapplicationschallenge.di.components.DaggerBlissApplicationComponent

class BlissApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<BlissApplication> {
        return DaggerBlissApplicationComponent.factory().create(this)
    }
}