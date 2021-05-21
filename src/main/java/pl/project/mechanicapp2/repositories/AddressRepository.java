package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.project.mechanicapp2.model.Address;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT * FROM address a WHERE a.car_owner_id = :id",
            nativeQuery = true)
    List<Address> findAddressByOwnerId(@Param("id") Long id);
}
