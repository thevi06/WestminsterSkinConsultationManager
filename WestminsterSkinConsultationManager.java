package CW2022;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{


    public final static int maxDocs=10;

    public ArrayList<Doctor> doctors =new ArrayList<>();

    private int freeSlots=maxDocs;
    public ArrayList<Doctor> doctorListTemp;

    @Override
    public void addDoctor(Doctor doctor) {
        if (getDoctors().size()>=maxDocs){
            System.out.println("List is already full");
        }
        else{
            getDoctors().add(doctor);
            freeSlots -=1;
            System.out.println("You added a Doctor.");
            //System.out.println(freeSlots);
        }

    }

    public void printDoctorList(){

        // clone ArrayList
        ArrayList<Doctor> doctorListTemp = (ArrayList<Doctor>) doctors.clone();

        if (getDoctors().isEmpty()) {
            System.out.println("Doctors list is empty");
        } else {
            Collections.sort(doctorListTemp, new Comparator<Doctor>() {
                @Override
                public int compare(Doctor d1, Doctor d2) {
                    return d1.getSurname().compareTo(d2.getSurname());
                }
            });
            System.out.println("*******List of all the Doctors********");
            for (Doctor doctor : doctorListTemp) {
                System.out.println("First Name :"+doctor.getName());
                System.out.println("Last Name :"+doctor.getSurname());
                System.out.println("Mobile No :"+doctor.getMobileNo());
                System.out.println("DOB :"+doctor.getDateOB());
                System.out.println("Medical License No :"+doctor.getMedLiceNo());
                System.out.println("Specialization :"+doctor.getSpecialisation());
                System.out.println("");
            }
        }
    }


    public void deleteDoctor(int medicalLicenseNumber){
        boolean found = false;
        for(Doctor doctor : getDoctors()){
            if (doctor.getMedLiceNo()==(medicalLicenseNumber)){
                found=true;
                getDoctors().remove(doctor);
                System.out.printf("removed doctor");
                //System.out.println("free slots remaining "+freeSlots);
                break;
            }
        }
        if(!found) {
            System.out.println("Invalid number");
        }
    }

    public void saveData() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/CW2022/Doctor.txt"));
            for (Doctor doc : doctors) {
                writer.write(doc.getName() + "," + doc.getSurname() + "," + doc.getMobileNo() + "," + doc.getDateOB() + "," + doc.getMedLiceNo() + "," + doc.getSpecialisation());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("\n Data saved in a text file");
    }

    public void loadData() throws IOException, ClassNotFoundException {


        File file = new File("src/CW2022/Doctor.txt");
        String[] filedata;

        Scanner scn = new Scanner(file);
        while (scn.hasNext()){
            filedata = scn.nextLine().split(",");
            LocalDate dateD = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if (filedata[3]!=null){
                dateD = LocalDate.parse(filedata[3].trim(),formatter);
            }
            doctors.add(new Doctor(filedata[0].trim(),filedata[1].trim(),Integer.parseInt(filedata[2].trim()),dateD,Integer.parseInt(filedata[4].trim()),filedata[5].trim()));

        }
    }




    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }


    public void setDoctorListTemp(ArrayList<Doctor> doctorListTemp) {
        this.doctorListTemp = doctorListTemp;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }
}
