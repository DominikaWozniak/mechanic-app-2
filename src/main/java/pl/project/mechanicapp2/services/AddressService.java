package pl.project.mechanicapp2.services;

import pl.project.mechanicapp2.model.Address;

import java.util.List;

public interface AddressService extends CrudService<Address> {

    List<Address> findByOwnerId(Long id);
}
