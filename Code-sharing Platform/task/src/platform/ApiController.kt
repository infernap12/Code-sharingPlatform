package platform

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import platform.api.CodeDto
import platform.api.PostNewCodeDto
import platform.api.PostNewCodeResponse
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/api")
class ApiController(@Autowired private val repo: SnippetService) {

    @PostMapping("/code/new")
    fun postNewCode(@RequestBody body: PostNewCodeDto): ResponseEntity<PostNewCodeResponse> {
        val now = LocalDateTime.now()
        val expiry = if (body.time > 0) now.plusSeconds(body.time.toLong()) else null
        val newCode = Snippet(
            code = body.code,
            lastModified = now,
            views = body.views.coerceAtLeast(0),
            expiry = expiry,
            timeRestricted = body.time > 0,
            viewsRestricted = body.views > 0,
        )
        val returned = repo.save(newCode)
        val response = PostNewCodeResponse(returned.id)
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }

    @GetMapping("/code/latest")
    fun getLatestCode(): ResponseEntity<List<CodeDto>> {
        val dtoList = repo.getTop10().toList().toList()
            .map(CodeDto::fromSnippet)
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dtoList)
    }

    @GetMapping("/code/{id}")
    fun getCode(@PathVariable id: UUID): ResponseEntity<CodeDto> {
        val dto: CodeDto
        try {
            dto = CodeDto.fromSnippet(repo.getById(id)!!)
        } catch (e: Exception) {
            throw SnippetNotFoundException(e)
        }
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
    }
}