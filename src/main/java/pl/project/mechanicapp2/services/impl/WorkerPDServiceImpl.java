package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Address;
import pl.project.mechanicapp2.model.WorkerPersonalData;
import pl.project.mechanicapp2.repositories.AddressRepository;
import pl.project.mechanicapp2.repositories.WorkerPDRepository;
import pl.project.mechanicapp2.services.WorkerPDService;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerPDServiceImpl implements WorkerPDService {

    private WorkerPDRepository workerPDRepository;
    private AddressRepository addressRepository;

    public WorkerPDServiceImpl(WorkerPDRepository workerPDRepository, AddressRepository addressRepository) {
        this.workerPDRepository = workerPDRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<WorkerPersonalData> findAllItems() {
        return workerPDRepository.findAll();
    }

    @Override
    public void saveItem(WorkerPersonalData item) {
        this.workerPDRepository.save(item);
    }

    @Override
    public WorkerPersonalData getItemById(Long id) {
        Optional<WorkerPersonalData> optional = workerPDRepository.findById(id);
        WorkerPersonalData workerPD = null;
        if (optional.isPresent()) {
            workerPD = optional.get();
        } else {
            throw new RuntimeException(" Worker not found for id :: " + id);
        }
        return workerPD;
    }

    @Override
    public void deleteItemById(Long id) {
        this.workerPDRepository.deleteById(id);
    }


}
