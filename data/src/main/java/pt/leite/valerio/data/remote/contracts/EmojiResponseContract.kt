package pt.leite.valerio.data.remote.contracts


import com.google.gson.annotations.SerializedName

data class EmojiResponseContract(
    @SerializedName("url")
    val url: String
)