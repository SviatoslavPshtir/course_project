package org.example.repos;

import org.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Iterable<User> findByLastName(String username);
}
