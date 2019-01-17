package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    User findById(long id);
}
