package edu.uncc.repository;

import edu.uncc.domain.Role;
import edu.uncc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);

    List<User> findAllByRole(Role role);
}
