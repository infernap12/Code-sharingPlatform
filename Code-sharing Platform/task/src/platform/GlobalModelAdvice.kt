package platform

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import java.time.format.DateTimeFormatter

@ControllerAdvice
class GlobalModelAdvice(
    @Autowired private val dateTimeFormatter: DateTimeFormatter,
    @Autowired private val dateFormatter: DateTimeFormatter,
) {

    @ModelAttribute
    fun addAttributes(model: Model) {
        model.addAttribute("dateTimeFormatter", dateTimeFormatter)
        model.addAttribute("dateFormatter", dateFormatter)
    }
}