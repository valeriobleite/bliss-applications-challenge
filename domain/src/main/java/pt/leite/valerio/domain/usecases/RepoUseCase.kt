package pt.leite.valerio.domain.usecases

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.RepoEntity
import pt.leite.valerio.domain.repositories.repo.RepoRepository

class RepoUseCase(private val repoRepository: RepoRepository) {

    fun getRepoList(login: String, page: Int, perPage: Int): Single<List<RepoEntity>> {
        return repoRepository.getRepoList(login, page, perPage)
    }
}