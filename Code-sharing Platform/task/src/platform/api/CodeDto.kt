package platform.api

import com.fasterxml.jackson.annotation.JsonProperty
import platform.CodeEntity

data class CodeDto(
    @JsonProperty val code: String,
    @JsonProperty val date: String
) {
    constructor(code: CodeEntity) : this(code.code, code.lastModified.toString())
}