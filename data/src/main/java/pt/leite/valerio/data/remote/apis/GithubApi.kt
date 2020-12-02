package pt.leite.valerio.data.remote.apis

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.data.remote.contracts.EmojiResponseContract
import retrofit2.http.GET

interface GithubApi {

    @GET("emojis")
    fun getEmojiList(): Single<List<EmojiResponseContract>>
}