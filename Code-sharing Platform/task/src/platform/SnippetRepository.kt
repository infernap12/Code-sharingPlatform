package platform

import org.springframework.data.jpa.repository.JpaRepository

interface SnippetRepository : JpaRepository<Snippet, Int> {
    fun findFirst10ByOrderByLastModifiedDesc(): List<Snippet>
}