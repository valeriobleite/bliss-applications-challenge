package pt.leite.valerio.blissaplicationschallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.BlissBaseActivity
import javax.inject.Inject

class MainActivity : BlissBaseActivity<MainActivityViewModel>() {

    override fun viewModelClass() = MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}