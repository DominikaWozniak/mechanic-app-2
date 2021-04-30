package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Car;
import pl.project.mechanicapp2.services.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> findAllItems() {
        return null;
    }

    @Override
    public void saveItem(Car item) {

    }

    @Override
    public Car getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }
}
