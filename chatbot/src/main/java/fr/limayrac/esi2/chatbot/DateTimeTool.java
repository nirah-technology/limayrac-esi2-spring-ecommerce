package fr.limayrac.esi2.chatbot;

import java.time.LocalDateTime;
import java.util.function.Function;


public class DateTimeTool implements Function<DateTimeTool.Request, DateTimeTool.Response> {
    
    public record Request() { };
    public record Response(String date, String time) { }
    
    @Override
    public Response apply(Request t) {
        final LocalDateTime datetime = LocalDateTime.now();
        final String date = datetime.toLocalDate().toString();
        final String time = datetime.toLocalTime().toString();
        return new Response(date, time);
    };


}
