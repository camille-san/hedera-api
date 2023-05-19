package io.kosmocat.hedera.services;

import com.google.common.hash.Hashing;
import io.kosmocat.hedera.entities.users.User;
import io.kosmocat.hedera.errors.ErrorCode;
import io.kosmocat.hedera.errors.HederaException;
import io.kosmocat.hedera.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Value("${pepper}")
    private String pepper;

    private final UserRepository userRepository;

    public User checkLogin(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(getSeasonedHashedPassword(password))) {
            userOptional.get().setPassword(null);
            return userOptional.get();
        } else {
            throw new HederaException(ErrorCode.BAD_LOGIN);
        }
    }

    public User addNewUser(User user) {
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new HederaException(ErrorCode.NEW_USER_EMAIL_TAKEN);
            } else {
                String password = user.getPassword();
                user.setPassword(getSeasonedHashedPassword(password));
                user = userRepository.save(user);
                user.setPassword(null);
                log.info("New user {} correctly created with id {}", user.getEmail(), user.getId());
                return user;
            }
        } catch (DataIntegrityViolationException ex) {
            throw new HederaException(ErrorCode.NEW_USER_FIELD_MISSING);
        }
    }

    public String getSeasonedHashedPassword(String plainPassword) {
        return Hashing.sha256()
                .hashString(plainPassword + pepper, StandardCharsets.UTF_8)
                .toString();
    }

}
