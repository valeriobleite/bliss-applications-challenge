package pt.leite.valerio.blissapplicationschallenge.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BlissBaseActivity<VIEW_MODEL: BlissBaseViewModel<VIEW_STATE, INTENT>, VIEW_STATE, INTENT>: AppCompatActivity() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: VIEW_MODEL
    abstract fun viewModelClass(): Class<VIEW_MODEL>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass()].apply {
            viewStateLive().observe(this@BlissBaseActivity, {
                render(it)
            })
        }
    }

    protected fun callIntent(intent: INTENT) {
        viewModel.process(intent)
    }

    abstract fun render(viewState: VIEW_STATE)
}