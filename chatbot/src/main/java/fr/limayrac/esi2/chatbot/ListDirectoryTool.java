package fr.limayrac.esi2.chatbot;

import java.io.File;
import java.util.function.Function;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

@Service("listDirectoryTool")
@Description("List the contenct of the given directory name or path.")
public class ListDirectoryTool implements Function<ListDirectoryTool.Request, ListDirectoryTool.Response> {
    public record Request(String directoryPath) { };
    public record Response(String[] filesOrDirectories) { };

    @Override
    public Response apply(Request t) {
        final File directory = new File(t.directoryPath);
        final String[] filesOrDirectories = directory.list();
        return new Response(filesOrDirectories);
    }
    
}
