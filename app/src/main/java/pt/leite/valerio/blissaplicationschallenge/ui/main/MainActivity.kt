package pt.leite.valerio.blissaplicationschallenge.ui.main

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity
import pt.leite.valerio.blissaplicationschallenge.utils.loadUrl

class MainActivity : BlissBaseActivity<MainActivityViewModel, MainActivityViewModel.ViewState, MainActivityViewModel.Intent>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomEmoji.setOnClickListener { callIntent(MainActivityViewModel.Intent.RandomIntent) }
    }

    override fun viewModelClass() = MainActivityViewModel::class.java

    override fun render(viewState: MainActivityViewModel.ViewState) {
        btnRandomEmoji.isEnabled = !viewState.isLoading

        viewState.emojiUI?.let {
            ivEmoji.loadUrl(it.url)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
}