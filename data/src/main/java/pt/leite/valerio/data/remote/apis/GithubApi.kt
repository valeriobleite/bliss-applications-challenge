package pt.leite.valerio.data.remote.apis

import io.reactivex.rxjava3.core.Single
import pt.leite.valerio.data.remote.response.AvatarResponse
import pt.leite.valerio.data.remote.response.EmojiResponse
import pt.leite.valerio.data.remote.response.ReposResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("emojis")
    fun getEmojiList(): Single<EmojiResponse>

    @GET("users/{login}")
    fun getAvatar(@Path("login") login: String): Single<AvatarResponse>

    @GET("users/{login}/repos")
    fun getReposList(@Path("login") login: String, @Query("page") page: Int, @Query("per_page") perPage: Int): Single<ReposResponse>

}