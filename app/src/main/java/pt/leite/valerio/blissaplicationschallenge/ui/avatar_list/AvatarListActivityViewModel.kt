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
            is AvatarListActivityIntent.DeleteIntent -> delete(intent.avatarUI)
        }
    }

    private fun getList() {
        callSingle(
            avatarUseCase.getAvatarList(),
            onLoading = { updateList(true, null, null) },
            onSuccess = { list -> updateList(false, list.map { AvatarUIMapper.toUI(it) }, null) },
            onError = { updateList(false, null, it) }
        )
    }

    private fun delete(avatarUI: AvatarUI) {
        callCompletable(
            avatarUseCase.deleteAvatar(AvatarUIMapper.toEntity(avatarUI)),
            onSuccess = { updateDelete(avatarUI, null) },
            onError = { updateDelete(null, it) }
        )
    }

    private fun updateList(isLoading: Boolean, avatarUIList: List<AvatarUI>?, error: Throwable?) {
        postValue(
            viewState.copy(
                listState = viewState.listState.copy(
                    isLoading = isLoading,
                    avatarUIList = avatarUIList,
                    error = error
                ),
                deleteState = AvatarListActivityViewState.DeleteState()
            )
        )
    }

    private fun updateDelete(avatarUI: AvatarUI?, error: Throwable?) {
        postValue(
            viewState.copy(
                listState = AvatarListActivityViewState.ListState(),
                deleteState = viewState.deleteState.copy(
                    avatarUI = avatarUI,
                    error = error
                )
            )
        )
    }
}
