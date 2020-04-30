package com.progressio.User.logic;

import com.progressio.User.dal.repo.UserRepo;
import com.progressio.User.exception.ResourceNotFoundException;
import com.progressio.User.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectionLogic {

    @Autowired
    UserRepo userRepo;

    public User addUser(User user) { return userRepo.save(user); }

    public void removeUser(User user) {
        long userid = user.getId();
        user = userRepo.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userid));

        userRepo.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll(); }

    public User getUserById(Long id) { return userRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", "id", id)); }
}
