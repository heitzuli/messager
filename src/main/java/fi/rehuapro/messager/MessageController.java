package fi.rehuapro.messager;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class MessageController {

    @GetMapping("/message")
    public Message messages() {
        return new Message(1, "This is the message");
    }

}
