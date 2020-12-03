package pt.leite.valerio.blissaplicationschallenge.repositories.emoji

interface BaseMapperEntityToRoom<ENTITY, ROOM> {
    fun toRoom(entity: ENTITY): ROOM
}