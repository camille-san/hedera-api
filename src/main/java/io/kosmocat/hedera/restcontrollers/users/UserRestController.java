package io.kosmocat.hedera.restcontrollers.users;

import io.kosmocat.hedera.entities.users.User;
import io.kosmocat.hedera.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> addNew(@RequestBody User user) {
        log.info("[REST] Adding new user: {}", user.getEmail());
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

}
