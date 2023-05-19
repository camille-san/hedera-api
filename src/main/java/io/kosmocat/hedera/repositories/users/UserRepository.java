package io.kosmocat.hedera.repositories.users;

import io.kosmocat.hedera.entities.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
