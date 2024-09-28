package platform

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller("/")
class WebController(
    @Autowired private val repo: SnippetRepository,
    @Autowired private val resourceLoader: ResourceLoader
) {


    @GetMapping("/code/{id}")
    fun getCode(
        @PathVariable id: Int,
        model: Model
    ): String {
        val snippet: Snippet
        try {
            snippet = repo.findById(id).orElseThrow()
        } catch (e: Exception) {
            throw UnknownSnippetException(e)
        }
        model.addAttribute("snippet", snippet)
        return "code"

    }

    @GetMapping("/code/latest")
    fun getLatest(model: Model): String {
        val snippets = repo.findFirst10ByOrderByLastModifiedDesc()
        model.addAttribute("snippets", snippets)
        return "latest"
    }

    @GetMapping("/code/new")
    fun postNewCode(): ResponseEntity<String> {
        val responseText = resourceLoader.getResource("classpath:newCode.html").file.readText()
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(responseText)
    }


}