package pt.leite.valerio.data.remote.apis

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.data.remote.response.AvatarResponse
import pt.leite.valerio.data.remote.response.EmojiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("emojis")
    fun getEmojiList(): Single<EmojiResponse>

    @GET("users/{login}")
    fun getAvatar(@Path("login") login: String): Single<AvatarResponse>
}