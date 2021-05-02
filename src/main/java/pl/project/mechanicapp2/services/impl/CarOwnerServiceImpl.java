package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.CarOwner;
import pl.project.mechanicapp2.repositories.CarOwnerRepository;
import pl.project.mechanicapp2.services.CarOwnerService;

import java.util.List;
import java.util.Optional;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

    private CarOwnerRepository carOwnerRepository;

    public CarOwnerServiceImpl(CarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    @Override
    public List<CarOwner> findAllItems() {
        return carOwnerRepository.findAll();
    }

    @Override
    public void saveItem(CarOwner item) {
        this.carOwnerRepository.save(item);
    }

    @Override
    public CarOwner getItemById(Long id) {
        Optional<CarOwner> optional = carOwnerRepository.findById(id);
        CarOwner carOwner = null;
        if (optional.isPresent()) {
            carOwner = optional.get();
        } else {
            throw new RuntimeException(" Owner not found for id :: " + id);
        }
        return carOwner;
    }

    @Override
    public void deleteItemById(Long id) {
        this.carOwnerRepository.deleteById(id);
    }
}
