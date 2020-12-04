package pt.leite.valerio.blissapplicationschallenge.repositories

interface BaseMapperEntityToRoom<ENTITY, ROOM> {
    fun toRoom(entity: ENTITY): ROOM
}