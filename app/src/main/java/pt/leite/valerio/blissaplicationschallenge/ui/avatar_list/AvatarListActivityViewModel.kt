package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list

import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseViewModel
import pt.leite.valerio.blissaplicationschallenge.ui.main.mappers.AvatarUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI
import pt.leite.valerio.domain.usecases.AvatarUseCase
import javax.inject.Inject

class AvatarListActivityViewModel @Inject constructor(private val avatarUseCase: AvatarUseCase): BlissBaseViewModel<AvatarListActivityViewState, AvatarListActivityIntent>() {

    init {
        viewState = AvatarListActivityViewState()
    }

    override fun process(intent: AvatarListActivityIntent) {
        when(intent) {
            AvatarListActivityIntent.LoadListIntent -> getList()
        }
    }

    private fun getList() {
        callSingle(
            avatarUseCase.getAvatarList(),
            onLoading = { updateAvatar(true, null, null) },
            onSuccess = { list -> updateAvatar(false, list.map { AvatarUIMapper.toUI(it) }, null) },
            onError = { updateAvatar(false, null, it) }
        )
    }

    private fun updateAvatar(isLoading: Boolean, avatarUIList: List<AvatarUI>?, error: Throwable?) {
        postValue(
            viewState.copy(
                isLoading = isLoading,
                avatarUIList = avatarUIList,
                error = error
            )
        )
    }
}
