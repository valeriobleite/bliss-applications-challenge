package pt.leite.valerio.blissaplicationschallenge.ui.base

interface BaseMapperEntityToUI<ENTITY, UI> {
    fun toUI(entity: ENTITY): UI
}