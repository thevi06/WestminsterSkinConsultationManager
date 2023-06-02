package CW2022;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

public class SkinConsultGUI extends JFrame {
    SecretKey key;
    JButton ascBtn;//ascending order button
    JButton btnAssignDoc;
    JTable docTable;
    JScrollPane paneA;//JPannel
    JPanel pan1;
    //new
/*    private JPanel panelMain;
    public JTextField txtName;
    public JTextField txtSurname;
    private JTextField txtDob;
    private JTextField txtMobNo;
    private JTextField txtPatId;
    private JButton okButton;
    private JButton cancelButton;*/

    public SkinConsultGUI(WestminsterSkinConsultationManager manager) {


        setTitle("Westminster Skin Consultation Center");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        JLabel header = new JLabel("List Of Doctors");
        header.setFont(new Font("Times New Roman", Font.BOLD, 20));
        header.setBounds(200,0,600,25);
        add(header);


        String[] columnNames = {"Name", "Surname", "Medical License No", "Specialization", "Mobile NO"};
        String[][] rowData = new String[manager.doctors.size()][10];
        unSortedGuiDataTable(rowData, manager);


        docTable = new JTable(rowData, columnNames);
        docTable.setDefaultEditor(Object.class, null); //get an uneditable table
        paneA = new JScrollPane(docTable);
        paneA.setBounds(25, 25, 550, 300);


//assign a doctor  button and open new gui
        btnAssignDoc = new JButton("Assign Doctor");
        btnAssignDoc.setBounds(25,326,200,30);
        add(btnAssignDoc);

        btnAssignDoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonAssignDoctorActionPerformed(e);
            }
        });



        //button to sort
        ascBtn = new JButton("Ascending order");
        ascBtn.setBounds(250, 326, 150, 30);

        ascBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortedGuiDataTable(rowData, manager);
                docTable.repaint(); //refresh the table
            }
        });

        add(paneA);
        add(ascBtn);
        setVisible(true);//make it visible
    }

    private void buttonAssignDoctorActionPerformed(ActionEvent e) {
        int selectedRow = docTable.getSelectedRow();
        String dL = docTable.getValueAt(selectedRow, 0).toString();
        DoctorLIstGUI availableDoctorGUI = new DoctorLIstGUI(dL);
        availableDoctorGUI.setVisible(true);
        this.dispose();
    }


    public void sortedGuiDataTable(String[][] rows, WestminsterSkinConsultationManager manager) {
        int i = 0;
        Collections.sort(manager.doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareTo(d2.getSurname());
            }
        });
        for (Doctor temp : manager.doctors) {
            rows[i][0] = temp.getName();
            rows[i][1] = temp.getSurname();
            rows[i][2] = String.valueOf(temp.getMedLiceNo());
            rows[i][3] = temp.getSpecialisation();
            rows[i][4] = String.valueOf(temp.getMobileNo());
            i++;
        }
    }

    public void unSortedGuiDataTable(String[][] rows, WestminsterSkinConsultationManager manager) {
        int x = 0;
        for (Doctor temp : manager.doctors) {
            rows[x][0] = temp.getName();
            rows[x][1] = temp.getSurname();
            rows[x][2] = String.valueOf(temp.getMedLiceNo());
            rows[x][3] = temp.getSpecialisation();
            rows[x][4] = String.valueOf(temp.getMobileNo());
            x++;
        }
    }




}




