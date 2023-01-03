package fi.rehuapro.messager;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Validated
public class MessageController {
    // Key = id, value = message
    private static final Map<String, Message> messageMap = new HashMap<>();

    @GetMapping("/message")
    public Map<String, Message> messages() {
        return messageMap;
    }

    /**
     * Creates a new message and saves it to database
     * @param requestMessage is
     * @return the generated id for the message
     */
    @PostMapping("/message")
    public String createMessage(@RequestBody Message requestMessage) {
        var id = UUID.randomUUID().toString();
        var message = new Message(id, requestMessage.content());
        messageMap.put(id, message);
        return id;
    }

    /**
     * Gets message based on id
     * @param id is the id of a message
     * @return the message
     */
    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable String id) {
        return messageMap.get(id);
    }

}
