package com.lcwd.hiber.hibernate_crash_course;

import org.hibernate.SessionFactory;

import com.lcwd.hiber.hibernate_crash_course.entities.Student;
import com.lcwd.hiber.hibernate_crash_course.util.HibernateUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    StudentService studentService =  new StudentService();
    
    //get by id  //read operation
	public void getStudentTest() {
		
//		Student student = studentService.getById(1);
//		System.out.println(student.getName()); 
//		
//		System.out.println(student.getCertificates().size());
//		student.getCertificates().forEach(certificate -> {
//			System.out.println(certificate.getTitle());
//		});
		
	}
	
}//end of class
