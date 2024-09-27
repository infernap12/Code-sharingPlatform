package platform

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class WebController {

    @GetMapping("/code")
    fun getCode(): ResponseEntity<String> {
        val codeEntity = CodeSharingPlatform.getCode()
        val responseText =
            "<html>\n" +
                    "<head>\n" +
                    "<title>Code</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<pre id=\"code_snippet\">\n" +
                    "${codeEntity.code}</pre>\n" +
                    "<span id=\"load_date\">${codeEntity.lastModified}" +
                    "</span>" +
                    "</body>\n" +
                    "</html>"
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(responseText)

    }

    @GetMapping("/code/new")
    fun postNewCode(): ResponseEntity<String> {
        val responseText =
            """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Create</title>
                </head>
                <body>
                <h2>Update Code Snippit</h2>
                <textarea id="code_snippet"></textarea>
                <p>
                    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
                </p>
                <script>
                function send() {
                    let object = {
                        "code": document.getElementById("code_snippet").value
                    };

                    let json = JSON.stringify(object);

                    let xhr = new XMLHttpRequest();
                    xhr.open("POST", '/api/code/new', false)
                    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                    xhr.send(json);

                    if (xhr.status == 200) {
                        alert("Success!");
                    }
                }
                </script>
                </body>
                </html>
            """.trimIndent()
        return ResponseEntity.ok().body(responseText)
    }


}