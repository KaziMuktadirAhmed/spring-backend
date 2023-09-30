package com.mrbin.service;

import com.mrbin.models.EStates.EAccountState;
import com.mrbin.models.EStates.ERole;
import com.mrbin.models.Recycler;
import com.mrbin.models.User;
import com.mrbin.repository.RecyclerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclerService {
    @Autowired
    private RecyclerRepository recyclerRepository;

    @Autowired
    private UserService userService;

    public Recycler createRecycler(Recycler recycler) {
        return recyclerRepository.save(recycler);
    }
    public List<Recycler> getAllRecyclers(){
        return recyclerRepository.findAll();
    }

    public boolean updateRecyclerPrivilegeStatus(String id, EAccountState state) {
        Optional<Recycler> recyclerQuery = recyclerRepository.findById(id);

        if(recyclerQuery.isPresent()) {
            Recycler recycler = recyclerQuery.get();
            recycler.setAccountState(state);

            String recyclerUserName = recycler.getName();
            boolean addRoleOperation = userService.addRole(recyclerUserName, ERole.ROLE_RECYCLER);

            if(addRoleOperation) {
                recyclerRepository.save(recycler);
                return true;
            }
            return false;
        }
        return false;
    }

    public Optional<Recycler> getRecyclerById(String id){
        return recyclerRepository.findById(id);
    }
    public void deleteRecyclerById(String id) {
        recyclerRepository.deleteById(id);
    }
}
