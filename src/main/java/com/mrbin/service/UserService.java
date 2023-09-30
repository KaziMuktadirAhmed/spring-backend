package com.mrbin.service;

import com.mrbin.models.EStates.ERole;
import com.mrbin.models.Role;
import com.mrbin.models.User;
import com.mrbin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean addRole(String username, ERole newRole) {
        Optional<User> userQuery = userRepository.findByUsername(username);

        if (userQuery.isPresent()) {
            User user = userQuery.get();
            Set<Role> roles = user.getRoles();
            roles.add(new Role(newRole));
            user.setRoles(roles);
            userRepository.save(user);

            return true;
        }

        return false;
    }
}
