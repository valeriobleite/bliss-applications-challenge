package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_avatar_list.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.avatar_list.adapters.AvatarItemAdapter
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity

class AvatarListActivity : BlissBaseActivity<AvatarListActivityViewModel, AvatarListActivityViewState, AvatarListActivityIntent>() {

    private val avatarItemAdapter by lazy { AvatarItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar_list)

        callIntent(AvatarListActivityIntent.LoadListIntent)

        rvAvatars.layoutManager = GridLayoutManager(this, 4)
        rvAvatars.adapter = avatarItemAdapter
    }

    override fun viewModelClass() = AvatarListActivityViewModel::class.java

    override fun render(viewState: AvatarListActivityViewState) {
        pgAvatars.isVisible = viewState.isLoading
        rvAvatars.isVisible = !viewState.isLoading

        viewState.avatarUIList?.let {
            avatarItemAdapter.setItems(it)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, AvatarListActivity::class.java))
        }
    }
}