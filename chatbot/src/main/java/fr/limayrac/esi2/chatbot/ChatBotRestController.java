package fr.limayrac.esi2.chatbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatBotRestController {

    private final ChatClient chatClient;

    public ChatBotRestController(ChatClient.Builder builder, ChatMemory memory) {
        this.chatClient = builder
            .defaultSystem("Always ask in french language. Your answer should be short and conscice. Your personnality is fun. No thinks.")
            .defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
            .build();
    }

    @GetMapping("/message")
    public String getMethodName(@RequestParam(name = "question") String question) {

        ToolCallback dateTimeToolCallback = FunctionToolCallback
            .builder("dateTimeTool", new DateTimeTool())
            .inputType(DateTimeTool.Request.class)
            .build();

        ToolCallback listDirectoryToolCallback = FunctionToolCallback
            .builder("listDirectoryTool", new ListDirectoryTool())
            .inputType(ListDirectoryTool.Request.class)
            .build();

        ToolCallback fileReaderToolCallback = FunctionToolCallback
            .builder("fileReaderTool", new FileReaderTool())
            .inputType(FileReaderTool.Request.class)
            .build();

        return this.chatClient
            .prompt()
            .toolCallbacks(
                dateTimeToolCallback,
                listDirectoryToolCallback,
                fileReaderToolCallback
            )
            .user(question)
            .call()
            .content();
    }
    
}
