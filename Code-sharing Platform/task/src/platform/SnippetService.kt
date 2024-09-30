package platform

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class SnippetService(val snippetRepository: SnippetRepository) {
    @Transactional
    fun getTop10(): List<Snippet> {
        val snippets: List<Snippet> = snippetRepository.findFirst10ByOrderByLastModifiedDesc().toList()
        return snippets
    }

    @Transactional
    fun getById(id: UUID): Snippet? {
        val snippet = snippetRepository.findByIdAndViewsGreaterThanZeroAndExpiryAfterNow(id)
            ?: throw SnippetNotFoundException(NullPointerException())
        assert(snippet.timeRestricted == (snippet.expiry != null))
        if (snippet.timeRestricted) {
            if (LocalDateTime.now() > snippet.expiry) {
                snippet.deleted = true
            }
        }
        if (snippet.viewsRestricted) {
            snippet.views -= 1
            if (snippet.views < 0) {
                snippet.deleted = true
            }
        }
        return snippetRepository.save(snippet)

    }

    fun save(newCode: Snippet): Snippet = snippetRepository.save(newCode)
}