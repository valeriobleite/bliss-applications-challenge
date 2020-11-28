package pt.leite.valerio.blissaplicationschallenge.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BlissApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<BlissApplication> {
        return DaggerBlissApplicationComponent.factory().create(this)
    }
}