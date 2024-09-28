package platform

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "snippets")
class Snippet(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0,
    var code: String,
    var lastModified: LocalDateTime

) {
    fun getTimeString(): String {
        //todo investigate more global method. Spring date formatter?
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(lastModified)
    }
}