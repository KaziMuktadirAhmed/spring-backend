package com.mrbin.controllers;

import com.mrbin.models.Organization;
import com.mrbin.models.Recycler;
import com.mrbin.models.User;
import com.mrbin.service.OrganizationService;
import com.mrbin.service.RecyclerService;
import com.mrbin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    RecyclerService recyclerService;

    @Autowired
    OrganizationService organizationService;

    @GetMapping(value = "users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK) ;
    }

    @GetMapping(value = "recyclers")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Recycler>> getAllRecyclers(){
        return new ResponseEntity<List<Recycler>>(recyclerService.getAllRecyclers(), HttpStatus.OK) ;
    }
    @GetMapping(value = "organizations")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Organization>> getAllOrganizations(){
        return new ResponseEntity<List<Organization>>(organizationService.getAllOrganizations(), HttpStatus.OK) ;
    }
}
