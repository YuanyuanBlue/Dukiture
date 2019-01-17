package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.User;
import edu.duke.ece651.Dukiture.repository.RoleRepository;
import edu.duke.ece651.Dukiture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String uname) {
        return userRepo.findByUsername(uname);
    }

    @Override
    public User findById(long id) {
        return userRepo.findOne(id);
    }
}
