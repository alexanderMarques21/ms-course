package br.com.hroauth.services;

import br.com.hroauth.entities.User;
import br.com.hroauth.feignclients.UserFeignClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserFeignClient userFeignClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email) {
        try {
            ResponseEntity<User> userResponse = userFeignClient.findByEmail(email);
            User user = userResponse.getBody();
            LOGGER.info("User found = {}", user.getEmail());
            return user;
        } catch (FeignException e) {
            LOGGER.error("Request failed, responseStatus =  {}", e.status());
            LOGGER.error("Responsebody = {}", e.responseBody());
            throw new ResponseStatusException(HttpStatus.valueOf(e.status()));
        }
    }
}
