package org.example.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentID;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private Doctor doctor;

    private Date appointmentDate;
    private Time appointmentTime;
    private String reason;

    public Appointment(Patient patient, Doctor doctor,String reason) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = Date.valueOf(LocalDate.now());
        this.appointmentTime = Time.valueOf(LocalTime.now());
        this.reason = reason;
    }

    public Appointment() {

    }

    public int getAppointmentID() { return appointmentID; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public Date getAppointmentDate() { return appointmentDate; }
    public Time getAppointmentTime() { return appointmentTime; }
    public String getReason() { return reason; }

    public void setPatientID(Patient patient) { this.patient = patient; }
    public void setDoctorID(Doctor doctor) { this.doctor = doctor; }
    public void setReason(String reason) { this.reason = reason; }
}