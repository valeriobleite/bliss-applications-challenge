package pt.leite.valerio.blissapplicationschallenge.ui.avatar_list

import pt.leite.valerio.blissapplicationschallenge.ui.main.models.AvatarUI

data class AvatarListActivityViewState(
    val listState: ListState = ListState(),
    val deleteState: DeleteState = DeleteState()
) {
    data class ListState(
        val isLoading: Boolean = false,
        val avatarUIList: List<AvatarUI>? = null,
        val error: Throwable? = null
    )

    data class DeleteState(
        val avatarUI: AvatarUI? = null,
        val error: Throwable? = null
    )
}