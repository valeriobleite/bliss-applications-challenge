package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list

import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI

sealed class AvatarListActivityIntent {
    object LoadListIntent: AvatarListActivityIntent()
    data class DeleteIntent(val avatarUI: AvatarUI): AvatarListActivityIntent()
}