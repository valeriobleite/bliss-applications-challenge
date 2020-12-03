package pt.leite.valerio.data.remote.response


import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import pt.leite.valerio.data.remote.deserialize.EmojiJsonDeserializer

@JsonDeserialize(using = EmojiJsonDeserializer::class)
data class EmojiResponse(
    val emojiList: List<Emoji>
) {
    data class Emoji(
        val url: String
    )
}