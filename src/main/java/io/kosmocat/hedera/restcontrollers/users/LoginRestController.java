package io.kosmocat.hedera.restcontrollers.users;

import io.kosmocat.hedera.entities.users.User;
import io.kosmocat.hedera.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
@Slf4j
@RequiredArgsConstructor
public class LoginRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> attemptLogin(@RequestParam String email, @RequestParam String password) {
        log.info("[REST] Attempt login user: {}", email);
        User user = userService.checkLogin(email, password);
        log.info("[REST] Login successful for user {}", email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
