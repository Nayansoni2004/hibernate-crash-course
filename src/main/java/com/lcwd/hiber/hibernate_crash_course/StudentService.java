package com.lcwd.hiber.hibernate_crash_course;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import com.lcwd.hiber.hibernate_crash_course.entities.Student;
import com.lcwd.hiber.hibernate_crash_course.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


public class StudentService { //this class is made for CRUD operations...
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	//save student (create operation)
	public void saveStudent(Student student) {
		try(Session session = sessionFactory.openSession()) { //try with resource ko use kia h to session automatic close ho jayega
			
			Transaction beginTransaction = session.beginTransaction();
			session.persist(student);
			beginTransaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	//get by id -> (read operation)
	public Student getById(long studentId) {
		
		try(Session session = sessionFactory.openSession()) {
			
			Student student = session.get(Student.class, studentId);
			return student; 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	//update operation
	public Student updateStudent(long studentId,Student student) {
		
		try(Session session = sessionFactory.openSession()) {
			
			Transaction transaction = session.beginTransaction();
			Student oldStudent = session.get(Student.class, studentId);
			
			if(oldStudent != null) {
				oldStudent.setName(student.getName());
				oldStudent.setFathersName(student.getFathersName());
//				...update more information
				
				oldStudent = session.merge(oldStudent); //oldStudent mai hi dal do jo updates kiye h information mai then usi ko return kr do..
			}
			
			transaction.commit();
			return oldStudent;
			
		}
		
	}
	
	
	//delete operation
	public void deleteStudent(long studentId) {
		
		try(Session session = sessionFactory.openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			Student studentObj = session.get(Student.class, studentId);
			
			if(studentObj != null) {
				session.remove(studentObj);
			}
			
			transaction.commit();
			
		}
		
	}
	
	
	//HQL[JPA] -> convert -> native query(SQL query) 
//	i.e database independent
	
	//get all student using HQL
	public List<Student> getAllStudentsHQL() {
		
		try(Session session = sessionFactory.openSession()) {
			String HQLquery = "FROM Student";
			Query<Student> query = session.createQuery(HQLquery, Student.class);
			return query.list();
		}
		
	} 
	
	
	
	//get Student by name
	public Student getStudentByNameHQL(String name) {
		
		try(Session session = sessionFactory.openSession()) {
			String HQLquery = "FROM Student WHERE name = :studentName";
			Query<Student> query = session.createQuery(HQLquery, Student.class);
			query.setParameter("studentName", name);
			return query.uniqueResult();
		}
		
	}

	

	
	//criteria api:
//	get all student of same college
	public List<Student> getStudentsByCollegeCriteria(String college) {
		try(Session session = sessionFactory.openSession()) {
			
			HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
			
			CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class); 
			
			Root<Student> root = query.from(Student.class);
			
			query.select(root).where(criteriaBuilder.equal(root.get("college"), college));
			
			Query<Student> query2 = session.createQuery(query);
			
			return query2.getResultList();
		}
	}
	
	
	//pagination
	public List<Student> getStudentWithPagination(int pageNo, int pageSize) {
		
		try(Session session = sessionFactory.openSession()) {
			
			String paginationQuery = "FROM Student";
			
			Query<Student> query = session.createQuery(paginationQuery, Student.class);
			
			query.setFirstResult((pageNo-1)*pageSize);
			
			query.setMaxResults(pageSize);
			
			return query.list();
			
		}//End of try
		
	}
	
	
	
}//end of class
