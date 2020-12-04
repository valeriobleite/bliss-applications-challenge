package pt.leite.valerio.blissapplicationschallenge.ui.main

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pt.leite.valerio.blissapplicationschallenge.R
import pt.leite.valerio.blissapplicationschallenge.ui.avatar_list.AvatarListActivity
import pt.leite.valerio.blissapplicationschallenge.ui.base.BlissBaseActivity
import pt.leite.valerio.blissapplicationschallenge.ui.emoji_list.EmojiListActivity
import pt.leite.valerio.blissapplicationschallenge.ui.repos_list.RepoListActivity
import pt.leite.valerio.blissapplicationschallenge.utils.loadUrl

class MainActivity : BlissBaseActivity<MainActivityViewModel, MainActivityViewState, MainActivityIntent>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomEmoji.setOnClickListener { callIntent(MainActivityIntent.RandomIntent) }
        btnEmojiList.setOnClickListener { EmojiListActivity.startActivity(this) }
        btnSearchAvatar.setOnClickListener { callIntent(MainActivityIntent.SearchIntent(etSearchAvatar.text.toString())) }
        btnAvatarList.setOnClickListener { AvatarListActivity.startActivity(this) }
        btnGoogleRepos.setOnClickListener { RepoListActivity.startActivity(this) }
    }

    override fun viewModelClass() = MainActivityViewModel::class.java

    override fun render(viewState: MainActivityViewState) {
        renderEmoji(viewState.emojiViewState)
        renderAvatar(viewState.avatarViewState)
    }

    private fun renderEmoji(viewState: MainActivityViewState.EmojiViewState) {
        btnRandomEmoji.isEnabled = !viewState.isLoading

        viewState.emojiUI?.let {
            ivEmoji.loadUrl(it.url)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun renderAvatar(viewState: MainActivityViewState.AvatarViewState) {
        btnSearchAvatar.isEnabled = !viewState.isLoading

        viewState.avatarUI?.let {
            ivEmoji.loadUrl(it.url)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}