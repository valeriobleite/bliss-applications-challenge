package pt.leite.valerio.blissaplicationschallenge.repositories.repo

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.blissaplicationschallenge.repositories.repo.mappers.RepoContractMapper
import pt.leite.valerio.data.remote.client.IBlissHttpClient
import pt.leite.valerio.domain.entities.RepoEntity
import pt.leite.valerio.domain.repositories.repo.RepoRepository

class RepoRepositoryImpl(private val client: IBlissHttpClient): RepoRepository {
    override fun getRepoList(login: String, page: Int, perPage: Int): Single<List<RepoEntity>> {
        return client.getGithubApi().getReposList(login, page, perPage).map {
            RepoContractMapper.toEntity(it)
        }
    }
}