package pt.leite.valerio.blissaplicationschallenge.ui.emoji_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_emoji_list.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity
import pt.leite.valerio.blissaplicationschallenge.ui.emoji_list.adapters.EmojiItemAdapter

class EmojiListActivity : BlissBaseActivity<EmojiListActivityViewModel, EmojiListActivityViewState, EmojiListActivityIntent>() {

    private val emojiItemAdapter by lazy { EmojiItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emoji_list)

        callIntent(EmojiListActivityIntent.LoadListIntent)

        rvEmojis.layoutManager = GridLayoutManager(this, 4)
        rvEmojis.adapter = emojiItemAdapter
    }

    override fun viewModelClass() = EmojiListActivityViewModel::class.java

    override fun render(viewState: EmojiListActivityViewState) {
        pbLoading.isVisible = viewState.isLoading

        viewState.emojiUIList?.let {
            emojiItemAdapter.setItems(it)
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, EmojiListActivity::class.java))
        }
    }
}