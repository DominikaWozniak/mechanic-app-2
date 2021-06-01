package pl.project.mechanicapp2.services.impl;

import pl.project.mechanicapp2.model.Invoice;
import pl.project.mechanicapp2.repositories.InvoiceRepository;
import pl.project.mechanicapp2.services.InvoiceService;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAllItems() {
        return null;
    }

    @Override
    public void saveItem(Invoice item) {

    }

    @Override
    public Invoice getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public void sumAllPrice() {

    }
}
