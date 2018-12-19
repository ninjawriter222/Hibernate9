/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
/**
 *
 * @author Poozer
 */
public class CreateStudentDemo {
    public static void main(String[] args) {
        
        // create session facotry
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        
        try{
            //create a student object
            System.out.println("Creating a new student object...");
            Student tempStudent = new Student("Devin", "Poe", "Devn.a.poe@gmail.com");
            
            //start a transaction
            session.beginTransaction();
            
            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);
            
            //commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }
}
