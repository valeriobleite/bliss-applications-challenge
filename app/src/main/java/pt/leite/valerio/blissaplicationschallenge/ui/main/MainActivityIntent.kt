package pt.leite.valerio.blissaplicationschallenge.ui.main

sealed class MainActivityIntent {
    object RandomIntent: MainActivityIntent()
    data class SearchIntent(val name: String): MainActivityIntent()
}