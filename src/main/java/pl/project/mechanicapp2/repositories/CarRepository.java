package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.project.mechanicapp2.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM car c WHERE c.car_owner_id = :id",
            nativeQuery = true)
    List<Car> findCarByOwnerId(@Param("id") Long id);
}
