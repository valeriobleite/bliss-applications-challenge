package pt.leite.valerio.blissapplicationschallenge.ui.base

interface BaseMapperEntityToUI<ENTITY, UI> {
    fun toUI(entity: ENTITY): UI
}