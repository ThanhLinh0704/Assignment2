/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author laptop lenovo
 */
public class Validation extends javax.swing.JFrame {

    public boolean checkInputSignUp(String firstName, String lastName, String userName, String password, String confirmPassword, String email, String address, String dayofbirth) {
        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || address.isEmpty() || dayofbirth.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() <= 6) {
            JOptionPane.showMessageDialog(this, "Password must be more than 6 characters", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Confirm Password does not match", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Ensure strict date parsing
        try {
            // Chuyển đổi String sang Date
            java.util.Date date = sdf.parse(dayofbirth);

            // Hiển thị thông báo nếu dữ liệu hợp lệ
            // JOptionPane.showMessageDialog(this, "Valid date: " + date);
        } catch (ParseException ex) {
            // Hiển thị thông báo lỗi nếu dữ liệu không hợp lệ
            JOptionPane.showMessageDialog(this, "Required to Enter Correct Format: dd/MM/yyyy", "Try again", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format. Please enter a valid email.", "Try again", JOptionPane.ERROR_MESSAGE);
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
