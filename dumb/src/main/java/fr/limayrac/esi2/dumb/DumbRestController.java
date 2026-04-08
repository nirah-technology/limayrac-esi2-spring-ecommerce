package fr.limayrac.esi2.dumb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DumbRestController {

    private final EcomerceClient ecomerceClient;

    public DumbRestController(@Autowired EcomerceClient ecomerceClient) {
        this.ecomerceClient = ecomerceClient;
    }
    
    @GetMapping("/dumb")
    public Map<String, Object> dumb() {
        return this.ecomerceClient.getUsers();
    }
    
}
