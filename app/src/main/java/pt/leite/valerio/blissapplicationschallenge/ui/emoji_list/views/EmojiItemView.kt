package pt.leite.valerio.blissapplicationschallenge.ui.emoji_list.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import kotlinx.android.synthetic.main.view_item_emoji.view.*
import pt.leite.valerio.blissapplicationschallenge.R
import pt.leite.valerio.blissapplicationschallenge.utils.loadUrl

class EmojiItemView(context: Context, attrs: AttributeSet? = null) :
    LinearLayoutCompat(context, attrs) {

    init {
        inflate(context, R.layout.view_item_emoji, this)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        orientation = HORIZONTAL
    }

    fun loadUrl(url: String) {
        ivEmoji.loadUrl(url)
    }

}