package CW2022;

import javax.crypto.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;

//import static CW2022.Consultation.consultations;

public class PatientDetUI extends JFrame {
    static WestminsterSkinConsultationManager manager1 = new WestminsterSkinConsultationManager();
    private static BufferedImage globalImage;
    SecretKey key; // Encryption key
    // Array for encrypted image store
    byte[] encryptedImageData;
    static ArrayList<Consultation> consultations = new ArrayList<>();

    private JTextField txt_Name;
    private JTextField txt_Surname;
    private JTextField txt_dateOfbirth;
    private JTextField txt_mobileNum;
    private JTextField txt_patientId;
    private JTextArea txt_notes;
    private JButton pdataSubmitButton;

    // Array list to store the patient details
    //public List<Patient> patientList = new ArrayList<Patient>();

    public PatientDetUI() {
        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setTitle("Patient Details Form");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();

        JLabel jl0 = new JLabel("PATIENT DETAILS FORM");
        jl0.setFont(new Font("Calibre", Font.BOLD, 16));
        jl0.setBounds(210, 10, 200, 20);
        add(jl0);

        JPanel jp1 = new JPanel();
        add(jp1, borderLayout.CENTER);
        jp1.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));

        GridLayout gridLayout = new GridLayout(10, 2);
        gridLayout.setVgap(10);
        jp1.setLayout(gridLayout);

        JLabel jl1 = new JLabel("Name of Patient :");
        txt_Name = new JTextField(20);
        jp1.add(jl1);
        jp1.add(txt_Name);

        JLabel jl2 = new JLabel("Surname of Patient :");
        txt_Surname = new JTextField(20);
        jp1.add(jl2);
        jp1.add(txt_Surname);

        JLabel jl4 = new JLabel("Patient Mobile Number :");
        txt_mobileNum = new JTextField(20);
        jp1.add(jl4);
        jp1.add(txt_mobileNum);

        JLabel jl5 = new JLabel("Patient ID :");
        txt_patientId = new JTextField(20);
        jp1.add(jl5);
        jp1.add(txt_patientId);

        JLabel jl6 = new JLabel("Patient Date of Birth :");
        txt_dateOfbirth = new JTextField(20);
        jp1.add(jl6);
        jp1.add(txt_dateOfbirth);

        JLabel jl7 = new JLabel("Notes :");
        txt_notes = new JTextArea(5, 20);
        jp1.add(jl7);
        jp1.add(txt_notes);

        pdataSubmitButton = new JButton("Submit");
        pdataSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consultation p = new Consultation();
                p.setName(txt_Name.getText());
                p.setSurname(txt_Surname.getText());
                p.setMobileNo(Integer.parseInt(txt_mobileNum.getText()));
                p.getPatientID(Integer.parseInt(txt_patientId.getText()));
                p.setDateOB(LocalDate.parse(txt_dateOfbirth.getText()));
                //p.set(txt_notes.getText());

                // Add the patient details to the patient list
                consultations.add(p);

                // Add the patient details to the database
                //PatientDAO.addPatient(p);

                // Clear the text fields
                txt_Name.setText("");
                txt_Surname.setText("");
                txt_mobileNum.setText("");
                txt_patientId.setText("");
                txt_dateOfbirth.setText("");
                txt_notes.setText("");

                JOptionPane.showMessageDialog(null, "Added successfully!");
            }

        });
        jp1.add(pdataSubmitButton);

        JButton pdataClearButton = new JButton("Clear");
        pdataClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_Name.setText("");
                txt_Surname.setText("");
                txt_mobileNum.setText("");
                txt_patientId.setText("");
                txt_dateOfbirth.setText("");
                txt_notes.setText("");
            }
        });
        jp1.add(pdataClearButton);


    }
    public void showConsultations() {

        JFrame f = new JFrame("Consultations");
        JPanel p = new JPanel();

        for (int x=0;x<consultations.size();x++){

            JButton b1 = new JButton(consultations.get(x).getName()+" - "+consultations.get(x).getConsulationDT());

            int finalX = x;
            b1.addActionListener(e -> {

                JFrame f1 = new JFrame("Details of "+consultations.get(finalX).getName()+"'s Appointment");
                JPanel p1 = new JPanel();

                JLabel l3 = new JLabel("Doctor's Name: ");
                JTextArea tArea0 = new JTextArea(consultations.get(finalX).getDoctor().getName()+" "+consultations.get(finalX).getDoctor().getSurname());
                tArea0.setEditable(false);
                JLabel l4 = new JLabel("Patient's Name: ");
                JTextArea tArea1 = new JTextArea(consultations.get(finalX).getName());
                tArea1.setEditable(false);
                JLabel l5 = new JLabel("Patient's Surname: ");
                JTextArea tArea2 = new JTextArea(consultations.get(finalX).getSurname());
                tArea2.setEditable(false);
                JLabel l6 = new JLabel("Patient's Date of Birth: ");
                JTextArea tArea3 = new JTextArea(String.valueOf(consultations.get(finalX).getDateOB()));
                tArea3.setEditable(false);
                JLabel l7 = new JLabel("Patient's Mobile Number: ");
                JTextArea tArea4 = new JTextArea(String.valueOf(consultations.get(finalX).getMobileNo()));
                tArea4.setEditable(false);
                JLabel l8 = new JLabel("Patient Id: ");
/*                JTextArea tArea5 = new JTextArea(String.valueOf(consultations.get(finalX).getPatientID()));
                tArea5.setEditable(false);*/
                JLabel l9 = new JLabel("Scheduled Date and Time: ");
                JTextArea tArea6 = new JTextArea(String.valueOf(consultations.get(finalX).getConsulationDT()));
                tArea6.setEditable(false);
                JLabel l10 = new JLabel("Appointment Cost: ");
                JTextArea tArea7 = new JTextArea(String.valueOf(consultations.get(finalX).getPrice()));
                tArea7.setEditable(false);
                JLabel l11 = new JLabel("Appointment Notes: ");
                JTextArea tArea8 = new JTextArea(consultations.get(finalX).getNote());
                tArea8.setEditable(false);

                try{
                    if (consultations.get(finalX).getEncryptedImageArray() != null){
                        JButton showImage = new JButton("Show Images");
                        p1.add(showImage);
                        showImage.addActionListener(e1 -> {
                            JFrame f11 = new JFrame();
                            JPanel p11 = new JPanel();
                            f11.add(p11);
                            int width = 600;
                            int height = 600;

                            Cipher cipher;
                            try {
                                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
                                throw new RuntimeException(ex);
                            }
                            try {
                                cipher.init(Cipher.DECRYPT_MODE, key);
                            } catch (InvalidKeyException ex) {
                                throw new RuntimeException(ex);
                            }
                            try {
                                byte[] decryptedImageData = cipher.doFinal(consultations.get(finalX).getEncryptedImageArray());
                                InputStream in = new ByteArrayInputStream(decryptedImageData);
                                BufferedImage image = ImageIO.read(in);

                                // resize the image
                                BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                                Graphics2D g = resizedImage.createGraphics();
                                g.drawImage(image, 0, 0, width, height, null);
                                g.dispose();

                                // create the JLabel with the resized image
                                JLabel label = new JLabel(new ImageIcon(resizedImage));
                                label.setPreferredSize(new Dimension(width, height));
                                ImageIcon imageIcon = new ImageIcon(resizedImage);
                                label.setIcon(imageIcon);

                                p11.add(label);
                                f11.pack();
                                f11.setVisible(true);
                            } catch (IllegalBlockSizeException | BadPaddingException | IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        });
                    }
                }catch (Exception ignored){

                }

                p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
                f1.add(p1);
                p1.add(l3);
                p1.add(tArea0);
                p1.add(l4);
                p1.add(tArea1);
                p1.add(l5);
                p1.add(tArea2);
                p1.add(l6);
                p1.add(tArea3);
                p1.add(l7);
                p1.add(tArea4);
                p1.add(l8);
                //p1.add(tArea5);
                p1.add(l9);
                p1.add(tArea6);
                p1.add(l10);
                p1.add(tArea7);
                p1.add(l11);
                p1.add(tArea8);

                f1.pack();
                f1.setVisible(true);
            });

            p.setPreferredSize(new Dimension(600,400));
            p.add(b1);
        }
        f.setPreferredSize(new Dimension(600, 400));
        f.add(p);
        f.pack();
        f.setVisible(true);
    }
}

