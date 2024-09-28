package platform

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class Snippet(
    val code: String,
    val lastModified: LocalDateTime
) {
    fun getTimeString(): String {
        //todo investigate more global method. Spring date formatter?
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(lastModified)
    }
}