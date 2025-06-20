package org.example.models;

import org.example.enums.Availability;

import javax.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int doctorID;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false)
        private String speciality;

        @Column(nullable = false)
        private String phoneNumber;

        @Column(nullable = false, unique = true)
        private String email;

        @Enumerated(EnumType.STRING)
        private Availability isAvailable = Availability.UNAVAILABLE;


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
