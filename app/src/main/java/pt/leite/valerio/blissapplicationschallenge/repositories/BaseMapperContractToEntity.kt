package pt.leite.valerio.blissapplicationschallenge.repositories

interface BaseMapperContractToEntity<CONTRACT, ENTITY> {
    fun toEntity(contract: CONTRACT): ENTITY
}