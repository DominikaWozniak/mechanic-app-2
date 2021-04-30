package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.CarOwner;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
}
