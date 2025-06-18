package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorID;
    private String firstName;
    private String lastName;
    private String speciality;
    private String phoneNumber;
    private String email;
    private boolean isAvailable;

    public Doctor(int doctorID, String firstName, String lastName, String speciality, String phoneNumber, String email) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Doctor(String firstName, String lastName, String specialty, String phone, String email) {
    }

    public int getDoctorID() { return doctorID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSpeciality() { return speciality; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}
