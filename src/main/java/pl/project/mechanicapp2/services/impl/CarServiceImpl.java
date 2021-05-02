package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Car;
import pl.project.mechanicapp2.repositories.CarRepository;
import pl.project.mechanicapp2.services.CarService;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllItems() {
        return carRepository.findAll();
    }

    @Override
    public void saveItem(Car item) {
        this.carRepository.save(item);
    }

    @Override
    public Car getItemById(Long id) {
        Optional<Car> optional = carRepository.findById(id);
        Car car = null;
        if (optional.isPresent()) {
            car = optional.get();
        } else {
            throw new RuntimeException(" Car not found for id :: " + id);
        }
        return car;
    }

    @Override
    public void deleteItemById(Long id) {
        this.carRepository.deleteById(id);
    }
}
