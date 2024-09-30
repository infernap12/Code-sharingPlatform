package platform

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface SnippetRepository : JpaRepository<Snippet, UUID> {
    @Query(
        """
        SELECT s FROM Snippet s
        WHERE (s.timeRestricted = false AND s.viewsRestricted = false AND s.deleted = false)
        ORDER BY s.lastModified DESC
        """
    )
    fun findFirst10ByOrderByLastModifiedDesc(pageable: Pageable = Pageable.ofSize(10)): Page<Snippet>

    @Query(
        """
        SELECT s FROM Snippet s
        WHERE (s.id = :id AND s.deleted = false)
        AND (
            (s.timeRestricted = false AND s.viewsRestricted = false)
            OR (s.timeRestricted = false AND s.viewsRestricted = true AND s.views > 0)
            OR (s.timeRestricted = true AND s.viewsRestricted = false AND s.expiry > CURRENT_TIMESTAMP)
            OR (s.timeRestricted = true AND s.viewsRestricted = true AND s.views > 0 AND s.expiry > CURRENT_TIMESTAMP)
        )
        """
    )
    fun findByIdAndViewsGreaterThanZeroAndExpiryAfterNow(id: UUID): Snippet?
}