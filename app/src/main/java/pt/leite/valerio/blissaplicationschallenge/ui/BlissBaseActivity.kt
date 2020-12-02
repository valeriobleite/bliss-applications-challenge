package pt.leite.valerio.blissaplicationschallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BlissBaseActivity<T: ViewModel>: AppCompatActivity() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract fun viewModelClass(): Class<T>

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass()]
    }

    inline fun <reified T> a(): Class<T> = T::class.java



}