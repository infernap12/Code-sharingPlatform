package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    private static CodeEntity code = new CodeEntity("""
            public static void main(String[] args) {
                SpringApplication.run(CodeSharingPlatform.class, args);
            }""", LocalDate.now());

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    public static void setCode(CodeEntity newCode) {
        code = newCode;
    }

    public static CodeEntity getCode() {
        if (code == null) {
            code = new CodeEntity("Null code", LocalDate.now());
        }
        return code;
    }

}
