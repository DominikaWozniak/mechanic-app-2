package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {


}
