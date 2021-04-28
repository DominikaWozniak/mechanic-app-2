package pl.project.mechanicapp2.services.impl;

import org.springframework.stereotype.Service;
import pl.project.mechanicapp2.model.Users;
import pl.project.mechanicapp2.repositories.UsersRepository;
import pl.project.mechanicapp2.services.UsersService;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAllItems() {
        return null;
    }

    @Override
    public void saveItem(Users item) {
    }

    @Override
    public Users getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }
}
