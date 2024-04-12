package com.api.userphone_onetoone.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PHONE_TB")
public class PhoneModel implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID

    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates the value for the field automatically
    private UUID id; // Field to store the identifier

    @Column(nullable = false, length = 30)
    private String number; // Field to store the phone number

    @OneToOne(fetch = FetchType.LAZY) // Defines a one-to-one association to UserModel, with lazy loading
    @JoinColumn(name = "user_id") // Specifies the foreign key column used for the association
    private UserModel user; // Associated user

    // Getters and Setters

    /**
     * Gets the ID of the phone.
     *
     * @return The ID of the phone.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the ID of the phone.
     *
     * @param id The ID of the phone.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the phone number.
     *
     * @param number The phone number.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the user associated with the phone.
     *
     * @return The user associated with the phone.
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * Sets the user associated with the phone.
     *
     * @param user The user associated with the phone.
     */
    public void setUser(UserModel user) {
        this.user = user;
    }
}
