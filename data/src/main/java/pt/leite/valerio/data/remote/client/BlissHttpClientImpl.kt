package pt.leite.valerio.data.remote.client

import pt.leite.valerio.data.remote.apis.GithubApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BlissHttpClientImpl(
    baseUrl: String
): IBlissHttpClient {

    private val githubApi: GithubApi

    init {
        createClient(baseUrl).apply {
            githubApi = create(GithubApi::class.java)
        }
    }

    private fun createClient(url: String): Retrofit {
        return Retrofit.Builder().apply {
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(url)
        }.build()
    }

    override fun getGithubApi(): GithubApi = githubApi
}