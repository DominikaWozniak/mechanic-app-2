package pl.project.mechanicapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.mechanicapp2.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
