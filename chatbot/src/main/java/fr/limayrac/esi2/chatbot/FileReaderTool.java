package fr.limayrac.esi2.chatbot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

@Service("fileReaderTool")
@Description("Read the content of the given file path.")
public class FileReaderTool implements Function<FileReaderTool.Request, FileReaderTool.Response>{
    public record Request(String filePath) { };
    public record Response(String content) { };

    @Override
    public Response apply(Request t) {
        try {
            final Path path = Paths.get(t.filePath);
            final String content = Files.readString(path);
            return new Response(content);
        } catch (IOException e) {
            return new Response("Error reading file: " + e.getMessage());
        }
    }
}
