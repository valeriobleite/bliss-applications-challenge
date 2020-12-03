package pt.leite.valerio.blissaplicationschallenge.ui.avatar_list.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import kotlinx.android.synthetic.main.view_item_avatar.view.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.utils.loadUrl

class AvatarItemView(context: Context, attrs: AttributeSet? = null) :
    LinearLayoutCompat(context, attrs) {

    init {
        inflate(context, R.layout.view_item_avatar, this)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        orientation = HORIZONTAL
    }

    fun loadUrl(url: String) {
        ivAvatar.loadUrl(url)
    }

}