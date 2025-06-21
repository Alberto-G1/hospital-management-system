package org.example.views;

import org.example.controller.*;
import org.example.enums.Availability;
import org.example.enums.Gender;
import org.example.enums.Role;
import org.example.models.*;

import java.time.LocalDate;
import java.util.Scanner;

public class HospitalView{
    private final Scanner scanner = new Scanner(System.in);
    private final UserController userController = new UserController();
    private final PatientController patientController = new PatientController();
    private final DoctorController doctorController = new DoctorController();
    private final AppointmentController appointmentController = new AppointmentController();

    public void start() {
        System.out.println("--- Welcome to CityCare General Hospital ---");
        boolean authenticated = false;
        while (!authenticated) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                registerUser();
            } else if ("2".equals(choice)) {
                authenticated = loginUser();
            } else {
                System.out.println("❌ Invalid choice.");
            }
        }
        mainMenu();
    }

    private void registerUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("Select role (ADMIN, DOCTOR, PATIENT): ");
        String roleInput = scanner.nextLine().toUpperCase();
        Role role = Role.valueOf(roleInput);
//        user.setRole(Role role);
        userController.register(user);
    }

    private boolean loginUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return userController.login(username, password);
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. List Patients");
            System.out.println("5. List Doctors");
            System.out.println("6. List Appointments");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": registerPatient(); break;
                case "2": addDoctor(); break;
                case "3": bookAppointment(); break;
                case "4": listPatients(); break;
                case "5": listDoctors(); break;
                case "6": listAppointments(); break;
                case "0": running = false; System.out.println("Logged out."); break;
                default: System.out.println("❌ Invalid choice."); break;
            }
        }
    }

    private void registerPatient() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        LocalDate dob = null;
        while (dob == null) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            try {
                dob = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid date.");
            }
        }
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Emergency Contact: ");
        String emergency = scanner.nextLine();

        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDateOfBirth(dob.toString());
        p.setGender(Gender.valueOf(gender));
        p.setAddress(address);
        p.setPhoneNumber(phone);
        p.setEmail(email);
        p.setEmergencyContact(emergency);

        patientController.registerPatient(p);
    }

    private void addDoctor() {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Speciality: ");
        String specialty = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Doctor d = new Doctor();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setSpeciality(specialty);
        d.setPhoneNumber(phone);
        d.setEmail(email);
        d.setIsAvailable(Availability.AVAILABLE);

        doctorController.addDoctor(d);
    }

    private void bookAppointment() {
        listPatients();
        System.out.print("Patient ID: ");
        int pid = Integer.parseInt(scanner.nextLine());
        listDoctors();
        System.out.print("Doctor ID: ");
        int did = Integer.parseInt(scanner.nextLine());
        System.out.print("Reason: ");
        String reason = scanner.nextLine();

        Patient p = patientController.listPatients().stream().filter(x -> x.getPatientID() == pid).findFirst().orElse(null);
        Doctor d = doctorController.listDoctors().stream().filter(x -> x.getDoctorID() == did).findFirst().orElse(null);

        if (p == null || d == null) {
            System.out.println("❌ Invalid Patient/Doctor ID.");
            return;
        }

        Appointment a = new Appointment(p, d, reason);
        appointmentController.bookAppointment(a);
    }

    private void listPatients() {
        for (Patient p : patientController.listPatients()) {
            System.out.println(p.getPatientID() + " - " + p.getFirstName() + " " + p.getLastName());
        }
    }

    private void listDoctors() {
        for (Doctor d : doctorController.listDoctors()) {
            System.out.println(d.getDoctorID() + " - Dr. " + d.getFirstName() + " " + d.getLastName());
        }
    }

    private void listAppointments() {
        for (Appointment a : appointmentController.listAppointments()) {
            System.out.println(a.getAppointmentID() + ": " + a.getPatient().getFirstName() + " with Dr. " +
                    a.getDoctor().getFirstName() + " for " + a.getReason());
        }
    }
}
