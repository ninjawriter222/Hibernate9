/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Poozer
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {
         // create session facotry
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();
        
        try{
            //create 3 student objects
            System.out.println("Creating 3 new student objects...");
            Student tempStudent1 = new Student("Bert", "Poe", "Bert.a.poe@gmail.com");
            Student tempStudent2 = new Student("Ernie", "Poe", "Ernie.a.poe@gmail.com");
            Student tempStudent3 = new Student("Elmo", "Poe", "Elmo.a.poe@gmail.com");
            
            //start a transaction
            session.beginTransaction();
            
            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
                                    
            
            //commit transaction
            session.getTransaction().commit();
            
            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }
}
