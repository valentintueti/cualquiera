package org.example.cualquiera.user.infrastructure;

import lombok.NoArgsConstructor;
import org.example.cualquiera.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
