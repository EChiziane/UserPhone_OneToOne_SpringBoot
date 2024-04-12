package com.api.userphone_onetoone.services;

import com.api.userphone_onetoone.models.UserModel;
import com.api.userphone_onetoone.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {
    final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;


    }

    @Transactional

    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll()
                ;
    }

    public Optional<UserModel> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
