package platform

import java.time.LocalDate

data class CodeEntity(
    val code: String,
    val lastModified: LocalDate
) {
}