package pt.leite.valerio.blissapplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissapplicationschallenge.repositories.repo.module.RepoRepositoryModule
import pt.leite.valerio.domain.repositories.repo.RepoRepository
import pt.leite.valerio.domain.usecases.RepoUseCase

@Module(includes = [RepoRepositoryModule::class])
class RepoUseCaseModule {
    @Provides
    fun provideRepoUseCase(repoRepository: RepoRepository): RepoUseCase = RepoUseCase(repoRepository)
}