package pl.project.mechanicapp2.services;

import pl.project.mechanicapp2.model.Invoice;

public interface InvoiceService extends CrudService<Invoice>{

    void sumAllPrice();
}
