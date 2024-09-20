package platform

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {

    @GetMapping("code")
    fun getCode(): ResponseEntity<String> {
        val responseText =
            "<html>\n" +
                    "<head>\n" +
                    "<title>Code</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<pre>\n" +
                    "${CodeSharingPlatform.code}</pre>\n" +
                    "</body>\n" +
                    "</html>"
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(responseText)

    }
}