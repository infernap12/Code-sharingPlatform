package platform

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController {
    @GetMapping("code")
    fun getCode(): ResponseEntity<CodeDto> {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(CodeDto(CodeSharingPlatform.code))
    }
}