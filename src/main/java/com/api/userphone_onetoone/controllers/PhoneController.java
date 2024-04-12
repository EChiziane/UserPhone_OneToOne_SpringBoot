package com.api.userphone_onetoone.controllers; // Package name in lowercase

import com.api.userphone_onetoone.dtos.PhoneDto;
import com.api.userphone_onetoone.models.PhoneModel;
import com.api.userphone_onetoone.services.PhoneServices;
import com.api.userphone_onetoone.services.UserServices;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks the class as a REST controller
@CrossOrigin(origins = "*", maxAge = 3600) // Enables Cross-Origin Resource Sharing (CORS)
@RequestMapping("/user-phone") // Maps HTTP requests to a specific handler method
public class PhoneController { // Class name capitalized according to Java naming conventions

    final PhoneServices phoneServices;
    final UserServices userServices;

    public PhoneController(PhoneServices phoneServices, UserServices userServices) {
        this.phoneServices = phoneServices;
        this.userServices = userServices;
    }

    // Endpoint for saving a new phone
    @PostMapping
    public ResponseEntity<Object> savePhone(@RequestBody PhoneDto phoneDto) {
        var phoneModel = new PhoneModel(); // Variable name in lowercase
        var user = userServices.getUserById(phoneDto.getUserId());

        // Check if user exists
        if (user.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user Found");

        phoneModel.setUser(user.get());
        BeanUtils.copyProperties(phoneDto, phoneModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneServices.savePhone(phoneModel));
    }

    // Endpoint for getting all phones
    @GetMapping
    public ResponseEntity<List<PhoneModel>> getPhones() {
        return ResponseEntity.status(HttpStatus.OK).body(phoneServices.getPhones());
    }
}
