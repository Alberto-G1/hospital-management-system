package org.example.views;

import org.example.controller.HospitalController;

import java.util.Scanner;


public class HospitalView {
    private final HospitalController controller;
    private final Scanner scanner;

    public HospitalView(HospitalController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- CityCare General Hospital ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. List Patients");
            System.out.println("5. List Doctors");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatientView();
                    break;
                case 2:
                    addDoctorView();
                    break;
                case 3:
                    bookAppointmentView();
                    break;
                case 4:
                    System.out.println("List of patients coming soon....");
                    //controller.listPatients();
                    break;
                case 5:
                    System.out.println("List of Doctors coming soon.....");
                    //controller.listDoctors();
                    break;
            }
        } while (choice != 0);
    }

    private void registerPatientView() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
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
        controller.addDoctor(firstName, lastName, specialty, phone, email);
    }

    private void bookAppointmentView() {
        //controller.listPatients();
        System.out.print("Enter patient ID: ");
        int pId = scanner.nextInt();
        //controller.listDoctors();
        System.out.print("Enter doctor ID: ");
        int dId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Appointment time (HH:MM): ");
        String time = scanner.nextLine();
        System.out.print("Reason for appointment: ");
        String reason = scanner.nextLine();
        controller.bookAppointment(pId, dId, date, time, reason);
    }
}

