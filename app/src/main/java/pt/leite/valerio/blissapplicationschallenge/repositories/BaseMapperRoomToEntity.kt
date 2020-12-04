package pt.leite.valerio.blissapplicationschallenge.repositories

interface BaseMapperRoomToEntity<ROOM, ENTITY> {
    fun toEntity(room: ROOM): ENTITY
}