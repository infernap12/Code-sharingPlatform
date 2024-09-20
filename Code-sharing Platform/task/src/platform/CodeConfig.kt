package platform

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CodeConfig {
    @Bean
    fun getCode(): String {
        return """public static void main(String[] args) {
    SpringApplication.run(CodeSharingPlatform.class, args);
}"""
    }
}