package platform

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import platform.api.CodeDto
import platform.api.PostNewCodeDto
import java.time.LocalDate

@RestController
@RequestMapping("/api")
class ApiController {
    @GetMapping("/code")
    fun getCode(): ResponseEntity<CodeDto> {
        val dto = CodeDto(CodeSharingPlatform.getCode())
        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            // todo break into separate service
            .body(dto)
    }

    @PostMapping("/code/new")
    fun postNewCode(@RequestBody body: PostNewCodeDto): ResponseEntity<String> {
        val newCode = CodeEntity(body.code, LocalDate.now())
        CodeSharingPlatform.setCode(newCode)
        return ResponseEntity.ok().body("{}")
    }
}