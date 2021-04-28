package pl.project.mechanicapp2.services;

import java.util.List;

public interface CrudService<T>{

    List<T> findAllItems();
    void saveItem(T item);
    T getItemById(Long id);
    void deleteItemById(Long id);
}
