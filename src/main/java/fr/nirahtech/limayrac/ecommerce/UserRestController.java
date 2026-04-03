package fr.nirahtech.limayrac.ecommerce;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/users")
@RestController
public class UserRestController {
    @GetMapping("")
    public Authentication getUserDetail(Authentication authentication) {
        return authentication;
    }
    
}
