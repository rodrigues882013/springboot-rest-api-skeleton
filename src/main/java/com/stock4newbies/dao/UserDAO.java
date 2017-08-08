package com.stock4newbies.dao;

import com.stock4newbies.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {
    User findByEmail(@Param("email") String email);
    User findByUsername(@Param("username") String username);

}
