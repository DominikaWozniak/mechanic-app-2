package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Address;
import pl.project.mechanicapp2.model.Users;
import pl.project.mechanicapp2.repositories.UsersRepository;
import pl.project.mechanicapp2.services.UsersService;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAllItems() {
        return usersRepository.findAll();
    }

    @Override
    public void saveItem(Users item) {
        this.usersRepository.save(item);
    }

    @Override
    public Users getItemById(Long id) {
        Optional<Users> optional = usersRepository.findById(id);
        Users users = null;
        if (optional.isPresent()) {
            users = optional.get();
        } else {
            throw new RuntimeException(" Users not found for id :: " + id);
        }
        return users;
    }

    @Override
    public void deleteItemById(Long id) {
        this.usersRepository.deleteById(id);
    }
}
