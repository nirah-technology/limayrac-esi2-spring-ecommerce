package fr.limayrac.esi2.chatbot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component("chatBotAgent")
public class ChatBotAgent {
    private final Map<String,Function<Object, Object>> tools = new HashMap<>(); 

    public final Map<String,Function<Object, Object>> getTools() {
        return Collections.unmodifiableMap(this.tools);
    }

    public final void registerTool(final String toolName, final Function<Object, Object> tool) {
        this.tools.put(toolName, tool);
    }

    public final Object executeTool(final String toolName, final Object toolInput) {
        return this.tools.get(toolName).apply(toolInput);
    }
}
