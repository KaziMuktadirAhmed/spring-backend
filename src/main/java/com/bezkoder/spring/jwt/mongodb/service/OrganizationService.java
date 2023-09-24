package com.bezkoder.spring.jwt.mongodb.service;

import com.bezkoder.spring.jwt.mongodb.models.Organization;
import com.bezkoder.spring.jwt.mongodb.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
    public List<Organization> getAllOrganizations(){
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(String id){
        return organizationRepository.findById(id);
    }
    public void deleteOrganizationById(String id) {
        organizationRepository.deleteById(id);
    }

}