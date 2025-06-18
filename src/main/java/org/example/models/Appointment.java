package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentID;
    private int patientID;
    private int doctorID;
    private String appointmentDate;
    private String appointmentTime;
    private String reason;

    public Appointment(int appointmentID, int patientID, String appointmentDate, String appointmentTime, String reason) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }

    public int getAppointmentID() { return appointmentID; }
    public int getPatientID() { return patientID; }
    public int getDoctorID() { return doctorID; }
    public String getAppointmentDate() { return appointmentDate; }
    public String getAppointmentTime() { return appointmentTime; }
    public String getReason() { return reason; }
}