package pt.leite.valerio.blissapplicationschallenge.di.modules

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.BuildConfig
import pt.leite.valerio.data.remote.client.BlissHttpClientImpl
import pt.leite.valerio.data.remote.client.IBlissHttpClient

@Module
class BlissHttpClientModule {
    @Provides
    fun provideBlissHttpClient(): IBlissHttpClient = BlissHttpClientImpl(BuildConfig.BASE_GITHUB_API_URL)
}