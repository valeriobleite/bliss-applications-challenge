package pt.leite.valerio.blissapplicationschallenge.ui.main

sealed class MainActivityIntent {
    object RandomIntent: MainActivityIntent()
    data class SearchIntent(val name: String): MainActivityIntent()
}