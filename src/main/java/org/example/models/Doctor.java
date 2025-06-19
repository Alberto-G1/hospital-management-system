package org.example.models;

import org.example.models.enums.Availability;

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
    @Enumerated(EnumType.STRING) // store as readable text
    @Column(length = 20)
    private Availability isAvailable;

    public Doctor(int doctorID, String firstName, String lastName, String speciality, String phoneNumber, String email) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isAvailable = Availability.UNAVAILABLE;
    }

    public Doctor() {

    }

    // GETTTERS AND SETTERS

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    public void setIsAvailable(Availability isAvailable) { this.isAvailable = Availability.UNAVAILABLE; }

    public int getDoctorID() { return doctorID; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getSpeciality() { return speciality; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getEmail() { return email; }
}
