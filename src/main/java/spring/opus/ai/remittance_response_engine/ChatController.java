package spring.opus.ai.remittance_response_engine;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ai/prompt")
    public String promptHandler(@RequestParam String message) {
        System.out.println("Inside Rest Controller for Chat");
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
