package pt.leite.valerio.blissaplicationschallenge.ui.repos_list

import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseViewModel
import pt.leite.valerio.blissaplicationschallenge.ui.repos_list.mappers.RepoUIMapper
import pt.leite.valerio.blissaplicationschallenge.ui.repos_list.models.RepoUI
import pt.leite.valerio.domain.usecases.RepoUseCase
import javax.inject.Inject

class RepoListActivityViewModel @Inject constructor(private val repoUseCase: RepoUseCase): BlissBaseViewModel<RepoListActivityViewState, RepoListActivityIntent>() {

    init {
        viewState = RepoListActivityViewState()
    }

    override fun process(intent: RepoListActivityIntent) {
        when(intent) {
            is RepoListActivityIntent.LoadListIntent -> getList(intent.isLoadingMore)
        }
    }

    private fun getList(isLoadingMore: Boolean) {
        if (isLoadingMore) {
            viewState = viewState.copy(page = viewState.page + 1)
        }

        callSingle(
            repoUseCase.getRepoList(REPO_NAME, viewState.page, PER_PAGE),
            onLoading = { updateRepo(
                isLoading = true,
                isLoadingMore = isLoadingMore,
                repoUIList = null,
                error = null
            ) },
            onSuccess = { list -> updateRepo(
                isLoading = false,
                isLoadingMore = isLoadingMore,
                repoUIList = list.map { RepoUIMapper.toUI(it) },
                error = null
            ) },
            onError = { updateRepo(
                isLoading = false,
                isLoadingMore = isLoadingMore,
                repoUIList = null,
                error = it
            ) }
        )
    }

    private fun updateRepo(isLoading: Boolean, isLoadingMore: Boolean, repoUIList: List<RepoUI>?, error: Throwable?) {
        postValue(
            viewState.copy(
                isLoading = isLoading,
                isLoadingMore = isLoadingMore,
                repoUIList = repoUIList,
                error = error
            )
        )
    }

    companion object {
        const val PER_PAGE = 50
        const val REPO_NAME = "google"
    }
}
