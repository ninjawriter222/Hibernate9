/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.jdbc;

import java.sql.Connection;

/**
 *
 * @author Poozer
 */
public class TestJdbc {
    public static void main(String[] args) {
       
        String jdbcUrl = "jdbc:mysql://localhostt:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";
        
        try{
           System.out.println("Connecting to databse: " + jdbcUrl);
           
           Connection myConn;
            myConn = DriverManger.getConnection(jdbcUrl,user,pass);
           
           System.out.println("Connection Successful!");
       }
       catch (Exception exc){
           exc.printStackTrace();
       }
    }
}
