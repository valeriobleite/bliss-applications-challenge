package pt.leite.valerio.data.remote.client

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import pt.leite.valerio.data.remote.apis.GithubApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

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
            addConverterFactory(
                JacksonConverterFactory.create(ObjectMapper().apply {
                    configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                })
            )
            baseUrl(url)
        }.build()
    }

    override fun getGithubApi(): GithubApi = githubApi
}