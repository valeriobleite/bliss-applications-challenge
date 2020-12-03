package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissRecyclerViewAdapter
import pt.leite.valerio.blissaplicationschallenge.ui.avatar_list.views.AvatarItemView
import pt.leite.valerio.blissaplicationschallenge.ui.main.models.AvatarUI

class AvatarItemAdapter: BlissRecyclerViewAdapter<AvatarUI>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(AvatarItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position)!!)
    }

    inner class ViewHolder(private val view: AvatarItemView): RecyclerView.ViewHolder(view) {
        fun bind(avatarUI: AvatarUI) {
            view.loadUrl(avatarUI.url)
            view.setOnClickListener {
                removeItem(avatarUI)
            }
        }
    }
}