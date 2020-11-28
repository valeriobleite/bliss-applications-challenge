package pt.leite.valerio.blissaplicationschallenge.application

import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import pt.leite.valerio.blissaplicationschallenge.application.modules.BlissHttpClientModule
import pt.leite.valerio.blissaplicationschallenge.data.BlissDataImpl
import pt.leite.valerio.blissaplicationschallenge.data.IBlissData
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import javax.inject.Singleton

@Module(includes = [
    AndroidSupportInjectionModule::class,
    BlissHttpClientModule::class
])
class BlissApplicationModule {
    @Provides
    @Singleton
    fun provideBlissData(
        client: IBlissHttpClient
    ): IBlissData = BlissDataImpl(client)
}