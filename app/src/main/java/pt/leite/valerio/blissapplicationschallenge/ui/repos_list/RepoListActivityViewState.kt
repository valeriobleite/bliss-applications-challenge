package pt.leite.valerio.blissapplicationschallenge.ui.repos_list

import pt.leite.valerio.blissapplicationschallenge.ui.repos_list.models.RepoUI

data class RepoListActivityViewState(
    val page: Int = 1,
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val repoUIList: List<RepoUI>? = null,
    val error: Throwable? = null
)