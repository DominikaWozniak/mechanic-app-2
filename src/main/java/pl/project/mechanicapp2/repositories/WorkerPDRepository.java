package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.WorkerPersonalData;


public interface WorkerPDRepository extends JpaRepository<WorkerPersonalData, Long> {

}
