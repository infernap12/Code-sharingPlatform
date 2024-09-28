package platform

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import platform.api.CodeDto
import platform.api.PostNewCodeDto
import platform.api.PostNewCodeResponse
import java.time.LocalDateTime

@RestController
@RequestMapping("/api")
class ApiController(@Autowired private val repo: SnippetRepository) {

    @PostMapping("/code/new")
    fun postNewCode(@RequestBody body: PostNewCodeDto): ResponseEntity<PostNewCodeResponse> {
        val newCode = Snippet(0, body.code, LocalDateTime.now())
        val index = repo.save(newCode).id
        val response = PostNewCodeResponse(index.toString())
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response)
    }

    @GetMapping("/code/latest")
    fun getLatestCode(): ResponseEntity<List<CodeDto>> {
        val dtoList = repo.findFirst10ByOrderByLastModifiedDesc().map(::CodeDto)
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dtoList)
    }

    @GetMapping("/code/{id}")
    fun getCode(@PathVariable id: Int): ResponseEntity<CodeDto> {
        val dto: CodeDto
        try {
            dto = CodeDto(repo.findById(id).orElseThrow())
        } catch (e: NoSuchElementException) {
            throw UnknownSnippetException(e)
        }
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
    }
}