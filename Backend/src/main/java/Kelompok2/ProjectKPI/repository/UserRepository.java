package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
