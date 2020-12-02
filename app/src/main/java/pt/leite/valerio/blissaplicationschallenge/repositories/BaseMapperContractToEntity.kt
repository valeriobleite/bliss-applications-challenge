package pt.leite.valerio.blissaplicationschallenge.repositories

interface BaseMapperContractToEntity<CONTRACT, ENTITY> {
    fun toEntity(contract: CONTRACT): ENTITY
}