package pt.leite.valerio.blissaplicationschallenge.repositories

interface BaseMapperEntityToRoom<ENTITY, ROOM> {
    fun toRoom(entity: ENTITY): ROOM
}