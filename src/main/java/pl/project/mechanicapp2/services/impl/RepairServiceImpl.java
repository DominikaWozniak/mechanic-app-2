package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Address;
import pl.project.mechanicapp2.model.Repair;
import pl.project.mechanicapp2.repositories.RepairRepository;
import pl.project.mechanicapp2.services.RepairService;

import java.util.List;
import java.util.Optional;

@Service
public class RepairServiceImpl implements RepairService {

    private RepairRepository repairRepository;

    @Override
    public List<Repair> findAllItems() {
        return repairRepository.findAll();
    }

    @Override
    public void saveItem(Repair item) {
        this.repairRepository.save(item);
    }

    @Override
    public Repair getItemById(Long id) {
        Optional<Repair> optional = repairRepository.findById(id);
        Repair repair = null;
        if (optional.isPresent()) {
            repair = optional.get();
        } else {
            throw new RuntimeException(" Repair not found for id :: " + id);
        }
        return repair;
    }

    @Override
    public void deleteItemById(Long id) {
        this.repairRepository.deleteById(id);
    }
}
