package pt.leite.valerio.blissaplicationschallenge.usecases

import dagger.Module
import dagger.Provides
import pt.leite.valerio.blissaplicationschallenge.repositories.repo.module.RepoRepositoryModule
import pt.leite.valerio.domain.repositories.repo.RepoRepository
import pt.leite.valerio.domain.usecases.RepoUseCase

@Module(includes = [RepoRepositoryModule::class])
class RepoUseCaseModule {
    @Provides
    fun provideRepoUseCase(repoRepository: RepoRepository): RepoUseCase = RepoUseCase(repoRepository)
}