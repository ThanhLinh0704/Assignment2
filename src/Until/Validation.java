/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;

import javax.swing.JOptionPane;

/**
 *
 * @author laptop lenovo
 */
public class Validation extends javax.swing.JFrame{
    
    public boolean checkInputSignUp(String firstName, String lastName, String userName, String password, String confirmPassword, String email, String address ) {
        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean checkInputLogin(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "UserName / Password not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    
    
}
