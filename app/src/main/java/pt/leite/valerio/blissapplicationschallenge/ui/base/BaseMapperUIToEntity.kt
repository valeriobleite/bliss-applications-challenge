package pt.leite.valerio.blissapplicationschallenge.ui.base

interface BaseMapperUIToEntity<UI, ENTITY> {
    fun toEntity(ui: UI): ENTITY
}