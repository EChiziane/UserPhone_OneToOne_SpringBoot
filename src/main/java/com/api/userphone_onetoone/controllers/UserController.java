package com.api.userphone_onetoone.controllers;

import com.api.userphone_onetoone.dtos.UserDto;
import com.api.userphone_onetoone.models.PhoneModel;
import com.api.userphone_onetoone.models.UserModel;
import com.api.userphone_onetoone.services.PhoneServices;
import com.api.userphone_onetoone.services.UserServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks the class as a REST controller
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/user-user") // Maps HTTP requests to a specific handler method
public class UserController {
    final UserServices userServices;
    final PhoneServices phoneServices;

    public UserController(UserServices userServices, PhoneServices phoneServices) {
        this.userServices = userServices;
        this.phoneServices = phoneServices;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
        var userModel = new UserModel();
        var phone = phoneServices.getPhoneById(userDto.getPhoneId());
        if (phone.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone not found");
        }
        userModel.setPhone((PhoneModel) phone.get());
        BeanUtils.copyProperties(userDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveUser(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userServices.getUsers());
    }
}
