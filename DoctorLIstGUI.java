package CW2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorLIstGUI extends JFrame {
    private JLabel labelName;
    private JTextField txt_date;
    private JTextField txt_time;

    public DoctorLIstGUI(){
        initUI();
        setLocationRelativeTo(null);
    }

    public DoctorLIstGUI(String dL){
        this();
        labelName.setText(dL);
    }

    private void initUI() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,400);
        BorderLayout borderLayout = new BorderLayout();

        JLabel label1 = new JLabel("Doctor Name :");
        label1.setBounds(5,5,200,20);
        add(label1);

        JLabel label2 = new JLabel("Enter consultation Date and Time to Check Availability of the Doctor,");
        label2.setBounds(5,5,400,80);
        add(label2);

        JButton bookDoctor = new JButton("Book Consultations");
        bookDoctor.setBounds(60,240,150,40);
        add(bookDoctor);
        bookDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookDoctor(e);
            }
        });

        JButton checkDoctor = new JButton("Check Availability");
        checkDoctor.setBounds(10,140,150,20);
        add(checkDoctor);

        JLabel label5 = new JLabel("Doctor is Available");
        label5.setBounds(5,5,200,400);
        add(label5);

        labelName = new JLabel();
        labelName.setBounds(210,5, 200,20);
        add(labelName);


        JLabel label3 = new JLabel("Consultation Time :");
        label3.setBounds(5,50,200,120);
        txt_date = new JTextField(20);
        add(label3);
        add(txt_date);

        JLabel label4 = new JLabel("Consultation Date :");
        label4.setBounds(5,5,200,160);
        txt_time = new JTextField(20);
        add(label4);
        add(txt_time);

    }

    private void bookDoctor(ActionEvent e) {
        PatientDetUI patientDetailsGUI = new PatientDetUI();
        patientDetailsGUI.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        DoctorLIstGUI availableDoctorGUI = new DoctorLIstGUI();
        availableDoctorGUI.setVisible(true);
    }

}

