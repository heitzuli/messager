package fi.rehuapro.messager;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
public class MessageController {
    // Key = id, value = message
    private static final Map<Long, Message> messageMap = new HashMap<>();

    @GetMapping("/message")
    public Map<Long, Message> messages() {
        return messageMap;
    }

    /**
     * Creates a new message and saves it to database
     * @param content is the body of the message
     * @return the generated id for the message
     */
    @PostMapping("/message")
    public Long createMessage(String content) {
        var id = 0L;
        var message = new Message(id, content);
        messageMap.put(id, message);
        return id;
    }

}
