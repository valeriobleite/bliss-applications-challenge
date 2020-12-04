package pt.leite.valerio.blissapplicationschallenge.ui.avatar_list

import pt.leite.valerio.blissapplicationschallenge.ui.main.models.AvatarUI

sealed class AvatarListActivityIntent {
    object LoadListIntent: AvatarListActivityIntent()
    data class DeleteIntent(val avatarUI: AvatarUI): AvatarListActivityIntent()
}