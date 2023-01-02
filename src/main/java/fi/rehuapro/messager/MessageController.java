package fi.rehuapro.messager;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class MessageController {
    private static final Map<Long, Message> messageMap = new HashMap<>();

    @GetMapping("/message")
    public Map<Long, Message> messages() {
        return messageMap;
    }

}
