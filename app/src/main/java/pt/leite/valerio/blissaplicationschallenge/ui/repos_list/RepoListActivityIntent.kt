package pt.leite.valerio.blissaplicationschallenge.ui.repos_list

sealed class RepoListActivityIntent {
    data class LoadListIntent(val isLoadingMore: Boolean): RepoListActivityIntent()
}