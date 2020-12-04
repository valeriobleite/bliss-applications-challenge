package pt.leite.valerio.blissapplicationschallenge.ui.emoji_list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.leite.valerio.blissapplicationschallenge.ui.base.BlissRecyclerViewAdapter
import pt.leite.valerio.blissapplicationschallenge.ui.emoji_list.views.EmojiItemView
import pt.leite.valerio.blissapplicationschallenge.ui.main.models.EmojiUI

class EmojiItemAdapter: BlissRecyclerViewAdapter<EmojiUI>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(EmojiItemView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(getItem(position)!!)
    }

    inner class ViewHolder(private val view: EmojiItemView): RecyclerView.ViewHolder(view) {
        fun bind(emojiUI: EmojiUI) {
            view.loadUrl(emojiUI.url)
            view.setOnClickListener {
                removeItem(emojiUI)
            }
        }
    }
}