package CW2022;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleMenu {
    final static Scanner scn =new Scanner(System.in);
    static SkinConsultationManager Smanager = new WestminsterSkinConsultationManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            Smanager.loadData();
            System.out.println("Data loaded");
        }catch (Exception e){
            e.printStackTrace();
        }
        menuLoop:
        while (true){
            displayMenu();

            // Validate the user input for integer
            if (scn.hasNextInt()) {
                int choice = scn.nextInt();
                switch (choice){
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        deleteDoctor();
                        break;
                    case 3:
                        Smanager.printDoctorList();
                        break;
                    case 4:
                        Smanager.saveData();

                        //System.out.println("data saved successfully");
                        break;
                    case 5:
                        Smanager.loadData();
                        break;
                    case 6:
                        SkinConsultGUI g1 = new SkinConsultGUI((WestminsterSkinConsultationManager) Smanager);
                        //Consult2 = g2 = new Consult2((WestminsterSkinConsultationManager) manager);
                        break;
                    case 7:
                        System.out.println("Thank You");
                        break menuLoop;
                    default:
                        System.out.println("invalid option");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scn.nextLine();  //validate
            }
        }
    }

    public static void displayMenu(){
        System.out.println("\n ----WELCOME TO WESTMINSTER SKIN CONSULTATION CENTER----");
        System.out.println("1: Add Doctor");
        System.out.println("2: Delete Doctor");
        System.out.println("3: Display all Doctors");//alphabetically according to the surname
        System.out.println("4: Save Data");
        System.out.println("5: Load Data");
        System.out.println("6: Display GUI");
        System.out.println("7: Quite application");



    }

    private static void addDoctor() {
        Doctor doctor;

        // Validations
        String name;
        while (true) {
            System.out.println("Enter the Doctor first name  :");
            name = scn.next();
            if (name.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Invalid input. You should enter a valid name.");
        }

        String surname;
        while (true) {
            System.out.println("Enter the doctor surname  :");
            surname = scn.next();
            if (surname.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Invalid input. You should enter a valid surname.");
        }

        int mobNumber;
        while (true) {
            System.out.println("Enter mobile number:");
            String mobileNumberInput = scn.next();
            if (mobileNumberInput.matches("\\d{10}")) {
                mobNumber = Integer.parseInt(mobileNumberInput);
                break;
            }
            System.out.println("Invalid input. You should enter a valid 10-digit mobile number.");
        }

        LocalDate dateStr;
        while (true) {
            System.out.print("Enter Date of birth yyy-mm-dd :");
            String dateInput = scn.next();
            try {
                dateStr = LocalDate.parse(dateInput);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. You should enter a valid date of birth in the format yyyy-MM-dd.");
            }
        }

        int medicalLicenseNumber;
        while (true) {
            System.out.println("Enter medical license number:");
            String medicalLicenseNumberInput = scn.next();
            if (medicalLicenseNumberInput.matches("[1-9]\\d*")) {
                medicalLicenseNumber = Integer.parseInt(medicalLicenseNumberInput);
                break;
            }
            System.out.println("Invalid input. You should enter a valid medical license number.");
        }

        String specialisation;
        while (true) {
            System.out.println("Enter specialisation  :");
            specialisation = scn.next();
            if (specialisation.matches("[a-zA-Z]+")) {
                break;
            }
            System.out.println("Invalid input. You should enter a valid specialisation.");
        }

        doctor = new Doctor(name, surname, mobNumber, dateStr, medicalLicenseNumber, specialisation);
        Smanager.addDoctor(doctor);
    }


    private static void deleteDoctor(){
        int medicalLicenseNumber;
        while (true) {
            System.out.println("Enter medical license number:");
            String medicalLicenseNumberInput = scn.next();
            if (medicalLicenseNumberInput.matches("[1-9]\\d*")) {
                medicalLicenseNumber = Integer.parseInt(medicalLicenseNumberInput);
                break;
            }
            System.out.println("Invalid input. You should enter a valid medical license number.");
        }

        Smanager.deleteDoctor(medicalLicenseNumber);
    }


}
