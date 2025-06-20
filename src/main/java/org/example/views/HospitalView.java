package org.example.views;

import org.example.controller.HospitalController;
import org.example.enums.Availability;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class HospitalView {
    private final HospitalController controller;
    private final Scanner scanner;

    public HospitalView(HospitalController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        String choice;
        boolean running = true;
        do {
            System.out.println("\n--- CityCare General Hospital ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. List Patients");
            System.out.println("5. List Doctors");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerPatientView();
                    break;
                case "2":
                    addDoctorView();
                    break;
                case "3":
                    bookAppointmentView();
                    break;
                case "4":
                    controller.listPatients();
                    break;
                case "5":
                    controller.listDoctors();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting system......");
                    break;
                default:
                    System.out.println("Invalid choice....Please try again.");
            }
        } while (running);
    }

    private void registerPatientView() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        String dob;
        LocalDate parsedDate;
        while (true) {
            System.out.print("Date of birth (YYYY-MM-DD): ");
            dob = scanner.nextLine();
            try {
                parsedDate = LocalDate.parse(dob);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD (e.g., 1999-03-27).");
            }
        }
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Emergency contact: ");
        String emergencyContact = scanner.nextLine();
        controller.registerPatient(firstName, lastName, dob, gender, address, phone, email, emergencyContact);
    }

    private void addDoctorView() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialty = scanner.nextLine();
        System.out.print("Phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Availability isAvailable = Availability.UNAVAILABLE;
        controller.addDoctor(firstName, lastName, specialty, phone, email, isAvailable);
    }

    private void bookAppointmentView() {
        controller.listPatients();

        int patientId;
        while (true) {
            System.out.print("Enter patient ID: ");
            try {
                patientId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Patient ID must be a number........ Please try again.");
            }
        }

        controller.listDoctors();

        int doctorId;
        while (true) {
            System.out.print("Enter doctor ID: ");
            try {
                doctorId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Doctor ID must be a number......... Please try again.");
            }
        }

        System.out.print("Reason for appointment: ");
        String reason = scanner.nextLine();

        controller.bookAppointment(patientId, doctorId, reason);
    }

}

