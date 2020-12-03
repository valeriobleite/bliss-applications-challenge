package pt.leite.valerio.blissaplicationschallenge.ui.main

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity
import pt.leite.valerio.blissaplicationschallenge.ui.emoji_list.EmojiListActivity
import pt.leite.valerio.blissaplicationschallenge.utils.loadUrl

class MainActivity : BlissBaseActivity<MainActivityViewModel, MainActivityViewState, MainActivityIntent>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomEmoji.setOnClickListener { callIntent(MainActivityIntent.RandomIntent) }
        btnEmojiList.setOnClickListener { EmojiListActivity.startActivity(this) }
    }

    override fun viewModelClass() = MainActivityViewModel::class.java

    override fun render(viewState: MainActivityViewState) {
        btnRandomEmoji.isEnabled = !viewState.isLoading

        viewState.emojiUI?.let {
            ivEmoji.loadUrl(it.url)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}