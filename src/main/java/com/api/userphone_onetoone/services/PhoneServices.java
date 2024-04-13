package com.api.userphone_onetoone.services;

import com.api.userphone_onetoone.models.PhoneModel;
import com.api.userphone_onetoone.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return phoneRepository.findAll();
    }

    public Optional getPhoneById(UUID id) {
        return phoneRepository.findById(id);
    }

    public void deletePhoneById(UUID id) {
        phoneRepository.deleteById(id);
    }


}
