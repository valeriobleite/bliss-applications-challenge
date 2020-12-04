package pt.leite.valerio.data.remote.client

import pt.leite.valerio.data.remote.apis.GithubApi

interface IBlissHttpClient {
    fun getGithubApi(): GithubApi
}