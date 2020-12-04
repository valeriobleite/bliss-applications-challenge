package pt.leite.valerio.data.remote.deserialize

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import pt.leite.valerio.data.remote.response.EmojiResponse

class EmojiJsonDeserializer : StdDeserializer<EmojiResponse>(EmojiResponse::class.java) {
    override fun deserialize(parser: JsonParser?, ctxt: DeserializationContext?): EmojiResponse {
        return EmojiResponse(
            parser?.codec?.readTree<JsonNode>(parser)?.map {
                EmojiResponse.Emoji(it.asText())
            } ?: listOf()
        )
    }

}