package pt.leite.valerio.blissaplicationschallenge.ui.main

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity

class MainActivity : BlissBaseActivity<MainActivityViewModel, MainActivityViewModel.ViewState, MainActivityViewModel.Intent>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomEmoji.setOnClickListener { callIntent(MainActivityViewModel.Intent.RandomIntent) }
    }

    override fun viewModelClass() = MainActivityViewModel::class.java

    override fun render(viewState: MainActivityViewModel.ViewState) {
        Log.i("MainActivity::render", viewState.toString())
    }
}