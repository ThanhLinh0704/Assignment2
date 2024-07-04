/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author laptop lenovo
 */
public class DateUtils {
        public static java.sql.Date convertStringToSqlDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Đảm bảo việc phân tích ngày tháng nghiêm ngặt
        try {
            java.util.Date date = sdf.parse(dateString);
            return new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Hoặc ném ngoại lệ tùy theo yêu cầu
        }
    }
    
}
