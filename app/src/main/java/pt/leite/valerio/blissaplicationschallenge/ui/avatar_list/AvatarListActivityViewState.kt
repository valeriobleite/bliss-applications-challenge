package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list

import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI

data class AvatarListActivityViewState(
    val isLoading: Boolean = false,
    val avatarUIList: List<AvatarUI>? = null,
    val error: Throwable? = null
)