package platform.api

import com.fasterxml.jackson.annotation.JsonProperty
import platform.Snippet

data class CodeDto(
    @JsonProperty val code: String,
    @JsonProperty val date: String
) {
    constructor(code: Snippet) : this(code.code, code.getTimeString())
}