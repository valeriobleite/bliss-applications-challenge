package pt.leite.valerio.blissapplicationschallenge.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.BuildConfig
import pt.leite.valerio.data.local.BlissDatabaseImpl
import pt.leite.valerio.data.local.IBlissDatabase

@Module
class BlissDatabaseModule {
    @Provides
    fun provideBlissDatabase(context: Context): IBlissDatabase = BlissDatabaseImpl(context, BuildConfig.DATABASE_NAME)
}