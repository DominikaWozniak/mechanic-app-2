package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
