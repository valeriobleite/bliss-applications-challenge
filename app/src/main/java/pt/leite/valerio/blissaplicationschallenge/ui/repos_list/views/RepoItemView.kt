package pt.leite.valerio.blissaplicationschallenge.ui.repos_list.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat
import kotlinx.android.synthetic.main.view_item_repo.view.*
import pt.leite.valerio.blissaplicationschallenge.R

class RepoItemView(context: Context, attrs: AttributeSet? = null) :
    LinearLayoutCompat(context, attrs) {

    init {
        inflate(context, R.layout.view_item_repo, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        orientation = HORIZONTAL
    }

    fun setName(name: String) {
        tvRepo.text = name
    }
}