package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
