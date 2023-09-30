package com.mrbin.service;

import com.mrbin.models.ERole;
import com.mrbin.models.Role;
import com.mrbin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void initializeRoles() {
        createRoleIfNotExists("ROLE_GUEST");
        createRoleIfNotExists("ROLE_USER");
        createRoleIfNotExists("ROLE_ADMIN");
        createRoleIfNotExists("ROLE_MODERATOR");
    }

    private void createRoleIfNotExists(String roleName) {
        Optional<Role> roleQuery = roleRepository.findByName(ERole.valueOf(roleName));
        if (roleQuery.isEmpty()) {
            Role role = new Role();
            role.setName(ERole.valueOf(roleName));
            roleRepository.save(role);
        }
    }
}
