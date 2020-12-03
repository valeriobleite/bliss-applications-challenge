package pt.leite.valerio.blissaplicationschallenge.repositories

interface BaseMapperRoomToEntity<ROOM, ENTITY> {
    fun toEntity(room: ROOM): ENTITY
}