package pt.leite.valerio.domain.repositories.repo

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.domain.entities.RepoEntity

interface RepoRepository {
    fun getRepoList(login: String, page: Int, perPage: Int): Single<List<RepoEntity>>
}