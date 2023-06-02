package CW2022;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Consultation extends Patient {
    @Serial
    private static final long serialVersionUID=1L;
    private LocalDateTime dateTime;
    private int price;
    private Date ConsulationDT;
    private String note;
    private Doctor doctor;



    public Consultation() {
        super("","",0, LocalDate.ofEpochDay(0),0);
    }



    public byte[] getEncryptedImageArray() {
        return encryptedImageArray;
    }


    public void setEncryptedImageArray(byte[] encryptedImageArray) {
        this.encryptedImageArray = encryptedImageArray;
    }
    byte[] encryptedImageArray;
    /*    public Consultation(LocalDateTime dateTime, int cost, String notes) {
            this.dateTime = dateTime;
            this.cost = cost;
            this.notes = notes;
        }*/
    public Date getConsulationDT() {
        return ConsulationDT;
    }

    public void setConsulationDT(Date consulationDT) {
        ConsulationDT = consulationDT;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getConsultationId() {
        return 0;
    }
}

