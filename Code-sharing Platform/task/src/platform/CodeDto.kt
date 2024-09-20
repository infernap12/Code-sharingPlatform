package platform

import com.fasterxml.jackson.annotation.JsonProperty

data class CodeDto(
    @JsonProperty val code: String
)