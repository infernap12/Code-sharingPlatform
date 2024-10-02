package platform.api

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.format.DateTimeFormatter


@Configuration
class AppConfig {
    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->

            // formatter
            val dateFormatter = dateFormatter()
            val dateTimeFormatter = dateTimeFormatter()


            // deserializers
            builder.deserializers(LocalDateDeserializer(dateFormatter))
            builder.deserializers(LocalDateTimeDeserializer(dateTimeFormatter))


            // serializers
            builder.serializers(LocalDateSerializer(dateFormatter))
            builder.serializers(LocalDateTimeSerializer(dateTimeFormatter))
        }
    }

    @Bean
    fun dateFormatter(): DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    @Bean
    fun dateTimeFormatter(): DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
}