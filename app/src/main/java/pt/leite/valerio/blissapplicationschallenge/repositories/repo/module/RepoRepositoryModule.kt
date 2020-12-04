package pt.leite.valerio.blissapplicationschallenge.repositories.repo.module

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.repositories.repo.RepoRepositoryImpl
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.repositories.repo.RepoRepository

@Module
class RepoRepositoryModule {
    @Provides
    fun provideRepoRepository(client: IBlissHttpClient): RepoRepository = RepoRepositoryImpl(client)
}