package br.com.hroauth.resources;

import br.com.hroauth.entities.User;
import br.com.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/search")
    public ResponseEntity<?> findUser(@RequestParam(name = "email") String email) {
        User user = service.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
