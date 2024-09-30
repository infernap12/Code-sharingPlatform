package platform

import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Formula
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "snippets")
class Snippet(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    var id: UUID = UUID.randomUUID(),
    @Column(name = "code")
    var code: String,
    @Column(name = "last_modified")
    var lastModified: LocalDateTime,
    @Column(name = "views")
    @ColumnDefault(value = "0")
    var views: Int = 0,
    @Column(name = "expiry_date", nullable = true)
    var expiry: LocalDateTime? = null,

    @Formula("expiry_date IS NOT NULL")
    val timeRestricted: Boolean = false,
    // seconds from now until expiry
    @Formula("DATEDIFF('SECOND', CURRENT_TIMESTAMP(), expiry_date)")
    val time: Int? = 0,

    var viewsRestricted: Boolean = false,
    var deleted: Boolean = false

) {
    fun getTimeString(): String {
        //todo investigate more global method. Spring date formatter?
        return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(lastModified)
    }
}