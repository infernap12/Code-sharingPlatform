package platform.api

import com.fasterxml.jackson.annotation.JsonProperty
import platform.Snippet
import java.time.LocalDateTime

data class CodeDto(
    @JsonProperty val code: String,
    @JsonProperty val date: LocalDateTime,
    @JsonProperty val time: Int,
    @JsonProperty val views: Int,
) {
    companion object {
        fun fromSnippet(snippet: Snippet): CodeDto {
            val code = snippet.code
            val date = snippet.lastModified
            val time = snippet.time ?: 0
            val views = snippet.views
            return CodeDto(code, date, time, views)
        }
    }
}