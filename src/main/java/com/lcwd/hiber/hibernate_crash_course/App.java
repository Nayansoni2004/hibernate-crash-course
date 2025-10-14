package com.lcwd.hiber.hibernate_crash_course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lcwd.hiber.hibernate_crash_course.entities.Certificate;
import com.lcwd.hiber.hibernate_crash_course.entities.Student;
import com.lcwd.hiber.hibernate_crash_course.util.HibernateUtil;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("We Are Going To Learn Hibernate [ORM Tool]!!!");
        
        /* create student -> save student -> hibernate -> database */
        
        //create student object
        Student student = new Student();
        student.setName("Drishti Soni");
        student.setCollege("Global");
        student.setActive(true);
        student.setPhone("799958989");
        student.setAbout("Beautiful Coder");
        student.setFathersName("Aarti Shukla");
        
        Certificate certificate = new Certificate();
        certificate.setTitle("Hibernate Certification");
        certificate.setAbout("This is Maven/Hibernate Certification");
        certificate.setLink("http://somelink");
        certificate.setStudent(student);
        
        Certificate certificate1 = new Certificate();
        certificate1.setTitle("Maven Certification");
        certificate1.setAbout("This is Maven Certification");
        certificate1.setLink("http://somelink...");
        certificate1.setStudent(student);
        
        student.getCertificates().add(certificate); 
        student.getCertificates().add(certificate1);
        
        SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();
//        System.out.println(sessionFactory);
        
        Session session = sessionFactory.openSession();    //session ik short lived object h isley close v krna h
        
        org.hibernate.Transaction transaction = null;
        
        try {
        	
        	transaction = session.beginTransaction();
        	
        	session.persist(student); /* save krne ka kam */
        	
        	transaction.commit();
        	
        	System.out.println("Student Saved Successfully!!!");
        	
        }catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	} else
        		e.printStackTrace();
        } finally {
        	session.close();
        }
        
        
        
        //calling get by id method (read method)
        //fetching student and his/her certificates...
        StudentService studentService = new StudentService();
        
        Student studentt = studentService.getById(3);
		System.out.println(studentt.getName()); 
		
		System.out.println(studentt.getCertificates().size());
		studentt.getCertificates().forEach(certificatee -> {
			System.out.println(certificatee.getTitle());
		});
		
		
		
		//calling criteria methods
		List<Student> studentsByCollegeCriteria = studentService.getStudentsByCollegeCriteria("Global");
		
		System.out.println(studentsByCollegeCriteria.size());
		
		
		
		//calling pagination method
		List<Student> studentWithPagination =  studentService.getStudentWithPagination(1, 10); //mtlb 1st page pe agar 10 records ha to poore 10 records aa jayenge...
		
		System.out.println(studentWithPagination.size());
		
    }//end of main 
}//end of class
