package com.api.userphone_onetoone.repository;

import com.api.userphone_onetoone.models.PhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, UUID> {
}
