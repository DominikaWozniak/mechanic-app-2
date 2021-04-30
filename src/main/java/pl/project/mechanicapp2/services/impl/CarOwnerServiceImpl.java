package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.CarOwner;
import pl.project.mechanicapp2.services.CarOwnerService;

import java.util.List;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {
    @Override
    public List<CarOwner> findAllItems() {
        return null;
    }

    @Override
    public void saveItem(CarOwner item) {

    }

    @Override
    public CarOwner getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }
}
