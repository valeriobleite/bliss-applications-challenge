package pt.leite.valerio.blissaplicationschallenge.di.modules

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.BuildConfig
import pt.leite.valerio.data.remote.client.BlissHttpClientImpl
import pt.leite.valerio.data.remote.client.IBlissHttpClient

@Module
class BlissHttpClientModule {
    @Provides
    fun provideBlissHttpClient(): IBlissHttpClient = BlissHttpClientImpl(BuildConfig.BASE_GITHUB_API_URL)
}