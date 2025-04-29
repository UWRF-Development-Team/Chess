package org.falcon.repository;

import org.falcon.model.chess.Chess;
import org.falcon.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
