package pl.project.mechanicapp2.services.impl;

import pl.project.mechanicapp2.model.Repair;
import pl.project.mechanicapp2.repositories.RepairRepository;
import pl.project.mechanicapp2.services.RepairService;

import java.util.List;

public class RepairServiceImpl implements RepairService {

    private RepairRepository repairRepository;

    @Override
    public List<Repair> findAllItems() {
        return null;
    }

    @Override
    public void saveItem(Repair item) {

    }

    @Override
    public Repair getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }
}
