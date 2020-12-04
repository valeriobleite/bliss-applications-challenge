package pt.leite.valerio.blissapplicationschallenge.ui.repos_list

sealed class RepoListActivityIntent {
    data class LoadListIntent(val isLoadingMore: Boolean): RepoListActivityIntent()
}