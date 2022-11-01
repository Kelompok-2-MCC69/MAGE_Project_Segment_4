package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmployee_Email(String username, String email);
}
