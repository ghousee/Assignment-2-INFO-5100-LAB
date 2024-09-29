/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mgmoh
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
//import javax.mail.internet.InternetAddress;
import java.util.regex.Pattern;

public class Main extends javax.swing.JFrame {
    private File photoFile;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        JFrame frame = new JFrame("User Profile Creation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);

        var txtMessage = "";
        photoJButton.addActionListener(e -> {
            JFileChooser file = new JFileChooser();
            if(file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                try{
                    
                    BufferedImage img = ImageIO.read(file.getSelectedFile());
                    Image edited_image = img.getScaledInstance(60, 80, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon (edited_image);
                    if(edited_image != null){
                        photoFile = file.getSelectedFile();
                        photoDisplayLabel.setText(file.getSelectedFile().getAbsolutePath());
                        photoDisplayLabel.setIcon(new ImageIcon(edited_image));
                    }
                    JOptionPane.showMessageDialog(this,txtMessage, "Photo Uploaded.", JOptionPane.ERROR_MESSAGE, icon);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Please upload image properly.");
                    ex.printStackTrace();
                }
            }
        });
        
        submitBtn.addActionListener(e -> {
            if(validateInputs()){
                displayUserProfile();
            }
        });
        
        resetBtn.addActionListener(e -> {
            firstNameField.setText("");
            lastNameField.setText("");
            ageField.setText("");
            phoneNumberField.setText("");
            emailField.setText("");
            photoDisplayLabel.setText("");
            photoFile = null;
            photoDisplayLabel.setIcon(null);
        });
    }
    
    private boolean validateInputs(){
        if(firstNameField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter First Name", "First Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(lastNameField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter Last Name", "Last Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ageField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Age", "Age Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int age = Integer.parseInt(ageField.getText().trim());
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number", "Age Error(Negative Number not allowed)", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number", "Age Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try{
            String phoneNumber = phoneNumberField.getText().trim();
            if (phoneNumberField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Phone Number", "Phone Number Missing", JOptionPane.ERROR_MESSAGE);
                return false;
        }
            else if(phoneNumber.length() != 10){
                JOptionPane.showMessageDialog(this,"Phone Number must be 10 digits","Phone Number Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Phone Number must be a valid number", "Phone Number Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (emailField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Email Address", "Email Address Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String email = emailField.getText().trim();
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()){
            JOptionPane.showMessageDialog(this, "Invalid email address format. Please enter the email again");
            return false;
        }
        if (photoFile == null) {
            JOptionPane.showMessageDialog(this, "Please select a photo", "Photo Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void displayUserProfile() {
        String userInfo = String.format("First Name: %s\nLast Name: %s\nAge: %s\nPhone Number: %s\nEmail: %s\nPhoto: %s",
                firstNameField.getText(), lastNameField.getText(), ageField.getText(),
                phoneNumberField.getText(), emailField.getText(), photoFile.getName());

        JOptionPane.showMessageDialog(this, userInfo, "User Profile", JOptionPane.INFORMATION_MESSAGE);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJPanel = new javax.swing.JPanel();
        Assignment2JLabel = new javax.swing.JLabel();
        firstNameJLabel = new javax.swing.JLabel();
        lastNameJLabel = new javax.swing.JLabel();
        ageJLabel = new javax.swing.JLabel();
        phoneNumberJLabel = new javax.swing.JLabel();
        emailJLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        photoSelectionJPanel = new javax.swing.JPanel();
        photoJLabel = new javax.swing.JLabel();
        photoJButton = new javax.swing.JButton();
        photoDisplayLabel = new javax.swing.JLabel();
        btnJPanel = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainJPanel.setForeground(new java.awt.Color(153, 255, 153));

        Assignment2JLabel.setText("Assignment 2 Java Swing - User Profile Creation");

        firstNameJLabel.setText("First Name:");

        lastNameJLabel.setText("Last Name:");

        ageJLabel.setText("Age:");

        phoneNumberJLabel.setText("Phone Number:");

        emailJLabel.setText("Email:");

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });

        photoJLabel.setText("Photo:");

        photoJButton.setText("Select Image:");

        javax.swing.GroupLayout photoSelectionJPanelLayout = new javax.swing.GroupLayout(photoSelectionJPanel);
        photoSelectionJPanel.setLayout(photoSelectionJPanelLayout);
        photoSelectionJPanelLayout.setHorizontalGroup(
            photoSelectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoSelectionJPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(photoDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(photoSelectionJPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(photoJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(photoJButton)
                .addGap(137, 137, 137))
        );
        photoSelectionJPanelLayout.setVerticalGroup(
            photoSelectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoSelectionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(photoSelectionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(photoJLabel)
                    .addComponent(photoJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photoDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        submitBtn.setText("Submit");

        resetBtn.setText("Reset");

        javax.swing.GroupLayout btnJPanelLayout = new javax.swing.GroupLayout(btnJPanel);
        btnJPanel.setLayout(btnJPanelLayout);
        btnJPanelLayout.setHorizontalGroup(
            btnJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnJPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnJPanelLayout.setVerticalGroup(
            btnJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnJPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(btnJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(resetBtn))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(Assignment2JLabel))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(phoneNumberJLabel)
                                .addGap(152, 152, 152)
                                .addComponent(phoneNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(emailJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(ageJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(firstNameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(lastNameJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGap(97, 97, 97))
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(photoSelectionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Assignment2JLabel)
                .addGap(18, 18, 18)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameJLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameJLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageJLabel)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberJLabel)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailJLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(photoSelectionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // Run the GUI in the Event Dispatch Thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true); // Create and show the Main frame
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Assignment2JLabel;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JPanel btnJPanel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberJLabel;
    private javax.swing.JLabel photoDisplayLabel;
    private javax.swing.JButton photoJButton;
    private javax.swing.JLabel photoJLabel;
    private javax.swing.JPanel photoSelectionJPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
