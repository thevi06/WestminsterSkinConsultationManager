package CW2022;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Serializable {
    private String name;
    private String surname;
    private int mobileNo;
    private LocalDate dateOB;

    public Person(String name, String surname, int mobileNumber, LocalDate dateOB) {
        this.name = name;
        this.surname = surname;
        this.mobileNo = mobileNumber;
        this.dateOB = dateOB;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getDateOB() {
        return dateOB;
    }

    public void setDateOB(LocalDate dateOB) {
        this.dateOB = dateOB;
    }




}

