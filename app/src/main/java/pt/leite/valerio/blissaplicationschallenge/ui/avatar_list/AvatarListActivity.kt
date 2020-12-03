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
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI

class AvatarListActivity :
    BlissBaseActivity<AvatarListActivityViewModel, AvatarListActivityViewState, AvatarListActivityIntent>(),
    AvatarItemAdapter.Listener {

    private val avatarItemAdapter by lazy { AvatarItemAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar_list)

        callIntent(AvatarListActivityIntent.LoadListIntent)

        rvAvatars.layoutManager = GridLayoutManager(this, 4)
        rvAvatars.adapter = avatarItemAdapter
    }

    override fun viewModelClass() = AvatarListActivityViewModel::class.java

    override fun render(viewState: AvatarListActivityViewState) {
        renderList(viewState.listState)
        renderDelete(viewState.deleteState)
    }

    private fun renderList(viewState: AvatarListActivityViewState.ListState) {
        pgAvatars.isVisible = viewState.isLoading
        rvAvatars.isVisible = !viewState.isLoading

        viewState.avatarUIList?.let {
            avatarItemAdapter.setItems(it)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun renderDelete(viewState: AvatarListActivityViewState.DeleteState) {
        viewState.avatarUI?.let {
            avatarItemAdapter.removeItem(it)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun onSelectedAvatar(avatarUI: AvatarUI) {
        callIntent(AvatarListActivityIntent.DeleteIntent(avatarUI))
    }

    companion object {
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, AvatarListActivity::class.java))
        }
    }
}