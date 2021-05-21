package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Address;
import pl.project.mechanicapp2.repositories.AddressRepository;
import pl.project.mechanicapp2.services.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllItems() {
        return addressRepository.findAll();
    }

    @Override
    public void saveItem(Address item) {
        this.addressRepository.save(item);
    }

    @Override
    public Address getItemById(Long id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address = null;
        if (optional.isPresent()) {
            address = optional.get();
        } else {
            throw new RuntimeException(" Address not found for id :: " + id);
        }
        return address;
    }

    @Override
    public void deleteItemById(Long id) {
        this.addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findByOwnerId(Long id) {
        return addressRepository.findAddressByOwnerId(id);
    }
}
