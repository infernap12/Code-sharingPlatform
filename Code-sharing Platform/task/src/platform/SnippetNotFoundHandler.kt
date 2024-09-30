package platform

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class SnippetNotFoundHandler : ResponseEntityExceptionHandler() {

    //handleSnippetNotFound
    @ExceptionHandler(SnippetNotFoundException::class)
    fun handleSnippetNotFound(
        e: SnippetNotFoundException,
        request: WebRequest
    ): ResponseEntity<String> {
        return ResponseEntity.notFound().build()
    }
}