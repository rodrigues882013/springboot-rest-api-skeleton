package com.stock4newbies.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stock4newbies.dao.EntityFactoryDAO;
import com.stock4newbies.dao.UserDAO;
import com.stock4newbies.models.User;
import com.stock4newbies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.json.JSONObject;



@RestController
public class UserController {

    @Autowired
    private UserDAO userDao;

    private final String RESOURCE_TYPE = "user";

    @RequestMapping("/users")
    public ResponseEntity<List<User>> list() {
        List<User> users = (List<User>) userDao.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        User u = userDao.save(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {
        User u = userDao.findOne(id);

        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setActive(user.getActive());

        User uSaved = userDao.save(u);
        return new ResponseEntity<>(uSaved, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
