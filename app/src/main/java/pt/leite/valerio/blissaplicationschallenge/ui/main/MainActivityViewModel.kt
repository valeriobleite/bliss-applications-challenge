package pt.leite.valerio.blissaplicationschallenge.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import pt.leite.valerio.domain.entities.EmojiEntity
import pt.leite.valerio.domain.usecases.EmojiUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val emojiUseCase: EmojiUseCase): ViewModel() {

    fun random() {
        Log.i("MainActivityViewModel","random()")
        emojiUseCase.getEmojiList()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<EmojiEntity>>() {
                override fun onSuccess(t: List<EmojiEntity>?) {
                    Log.i("MainActivityViewModel","doOnSuccess()")
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                    Log.i("MainActivityViewModel","doOnError()")
                }

            })
    }
}