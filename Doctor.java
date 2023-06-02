package CW2022;

import java.time.LocalDate;
import java.util.Objects;

public class Doctor extends Person{
    private int medLiceNo;
    private String specialisation;

    public Doctor(String name, String surname, int mobileNumber, LocalDate dateOB, int medicalLicenseNumber, String specialisation) {
        super(name, surname, mobileNumber, dateOB);
        this.medLiceNo = medicalLicenseNumber;
        this.specialisation = specialisation;
    }

    public int getMedLiceNo() {
        return medLiceNo;
    }

    public void setMedLiceNo(int medLiceNo) {
        this.medLiceNo = medLiceNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

/*    @Override
    public String toString() {
        return super.toString()+
                "medicalLicenseNumber=" + medicalLicenseNumber +
                ", specialisation='" + specialisation ;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return medLiceNo == doctor.medLiceNo && Objects.equals(specialisation, doctor.specialisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), medLiceNo, specialisation);
    }

}
