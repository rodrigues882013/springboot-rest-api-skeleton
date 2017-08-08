package com.stock4newbies.dao;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EntityDAO<T> {
    T getById(String id);
    List<T> list();
    T create(T object);
    Boolean delete(String id);
    T update(T object);
}
