package pt.leite.valerio.blissaplicationschallenge.ui.base

interface BaseMapperUIToEntity<UI, ENTITY> {
    fun toEntity(ui: UI): ENTITY
}