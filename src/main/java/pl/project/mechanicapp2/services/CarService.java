package pl.project.mechanicapp2.services;

import pl.project.mechanicapp2.model.Car;

import java.util.List;

public interface CarService extends CrudService<Car> {

    List<Car> findCarByOwnerId(Long id);
}
