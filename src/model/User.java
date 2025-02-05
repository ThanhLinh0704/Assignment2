/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;




/**
 *
 * @author laptop lenovo
 */
public class User {

    private int iduser;
    private String useName;
    private String password;
    private String firstName;
    private String lastName;
    private int gender;
    private String email;
    private String address;
    private String region;
    private Date dayofBirth;

    public User(int iduser, String useName, String password, String firstName, String lastName, int gender, String email, String address, String region, Date dayofBirth) {
        this.iduser = iduser;
        this.useName = useName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.region = region;
        this.dayofBirth = dayofBirth;

    }

    public User(String useName) {
        this.useName = useName;
    }

    public User(int id, String userName) {
        this.useName = userName;
        this.iduser = id;
    }

    public User() {
    }

    public User(int userId, String username, String firstName, String lastName, String region) {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getDayofBirth() {
        return dayofBirth;
    }

    public void setDayofBirth(Date dayofBirth) {
        this.dayofBirth = dayofBirth;
    }

}
