package pt.leite.valerio.blissapplicationschallenge.ui.avatar_list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.leite.valerio.blissapplicationschallenge.ui.avatar_list.views.AvatarItemView
import pt.leite.valerio.blissapplicationschallenge.ui.base.BlissRecyclerViewAdapter
import pt.leite.valerio.blissapplicationschallenge.ui.main.models.AvatarUI

class AvatarItemAdapter(private val listener: Listener): BlissRecyclerViewAdapter<AvatarUI>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(AvatarItemView(parent.context), listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position)!!)
    }

    inner class ViewHolder(private val view: AvatarItemView, private val listener: Listener): RecyclerView.ViewHolder(view) {
        fun bind(avatarUI: AvatarUI) {
            view.loadUrl(avatarUI.url)
            view.setOnClickListener {
                listener.onSelectedAvatar(avatarUI)
            }
        }
    }

    interface Listener {
        fun onSelectedAvatar(avatarUI: AvatarUI)
    }
}