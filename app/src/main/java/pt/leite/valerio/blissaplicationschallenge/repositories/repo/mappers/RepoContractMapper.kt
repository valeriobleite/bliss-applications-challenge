package pt.leite.valerio.blissaplicationschallenge.repositories.repo.mappers

import pt.leite.valerio.blissaplicationschallenge.repositories.BaseMapperContractToEntity
import pt.leite.valerio.data.remote.response.ReposResponse
import pt.leite.valerio.domain.entities.RepoEntity

object RepoContractMapper: BaseMapperContractToEntity<ReposResponse, List<RepoEntity>> {
    override fun toEntity(contract: ReposResponse) = contract.map {
        RepoEntity(it.fullName!!)
    }
}