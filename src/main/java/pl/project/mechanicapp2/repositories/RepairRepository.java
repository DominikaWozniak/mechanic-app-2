package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
