package com.api.userphone_onetoone.models; // Correção na nomenclatura do pacote

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PHONE_TB")
public class PhoneModel implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID

    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o valor para o campo
    private UUID id; // Campo para armazenar o identificador

    @Column(nullable = false, length = 30)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
