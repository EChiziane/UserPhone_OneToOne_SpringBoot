package com.api.userphone_onetoone.services;

import com.api.userphone_onetoone.models.PhoneModel;
import com.api.userphone_onetoone.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServices {

    final PhoneRepository phoneRepository;

    public PhoneServices(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;


    }

    @Transactional

    public PhoneModel savePhone(PhoneModel phoneModel) {
        return phoneRepository.save(phoneModel);
    }

    public List<PhoneModel> getPhones() {
        return phoneRepository.findAll()
                ;
    }

}
