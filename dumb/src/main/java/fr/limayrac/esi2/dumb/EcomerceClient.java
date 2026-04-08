package fr.limayrac.esi2.dumb;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component("ecomerceClient")
@FeignClient(name = "ECOMMERCE")
public interface EcomerceClient {
    
    @GetMapping(path = "/api/users", consumes = "application/json")
    public Map<String, Object> getUsers();
    
}
