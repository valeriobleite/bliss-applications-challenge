package pt.leite.valerio.blissaplicationschallenge.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import pt.leite.valerio.domain.entities.EmojiEntity

abstract class BlissBaseViewModel<VIEW_STATE, INTENT>: ViewModel() {
    private val disposable = CompositeDisposable()

    private val viewStateLiveData by lazy { MutableLiveData<VIEW_STATE>() }
    protected var viewState: VIEW_STATE
        get() = viewStateLiveData.value ?: throw UninitializedPropertyAccessException("\"viewState\" was queried before being initialized")
        set(value) {
            viewStateLiveData.value = value
        }

    fun viewStateLive(): LiveData<VIEW_STATE> = viewStateLiveData

    abstract fun process(intent: INTENT)

    protected fun postValue(viewState: VIEW_STATE) {
        viewStateLiveData.postValue(viewState)
    }

    protected fun <T> callSingle(single: Single<T>, onLoading: (() -> Unit)? = null, onSuccess: (T) -> Unit, onError: (Throwable?) -> Unit) {
        onLoading?.invoke()

        disposable.add(
            single
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<T>() {
                    override fun onSuccess(t: T) {
                        onSuccess.invoke(t)
                    }

                    override fun onError(error: Throwable?) {
                        onError.invoke(error)
                    }

                })
        )
    }

    protected fun callCompletable(single: Completable, onLoading: (() -> Unit)? = null, onSuccess: () -> Unit, onError: (Throwable?) -> Unit) {
        onLoading?.invoke()

        disposable.add(
            single
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onSuccess.invoke()
                    }

                    override fun onError(error: Throwable?) {
                        onError.invoke(error)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}