package pt.leite.valerio.blissaplicationschallenge.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target

fun ImageView.loadUrl(url: String) {
    Glide.with(this)
        .load(url)
//        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//        .centerCrop()
        .into(this)
}