package com.spring.orm.SpringORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import Entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//insert
	@Transactional
	public int insert(Student student) {
	Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//get data
	
	public Student getstudent( int studentid) {
		
		Student student= this.hibernateTemplate.get(Student.class, studentid);
		return student;
	}
	
	
	//get all students 
	
	public List<Student> getAllStudent(){
	List<Student> students=	this.hibernateTemplate.loadAll(Student.class);
	return students;
		
	}
	
	//deleting the data
	@Transactional
	public void deleteData(int studentid) {
		
	Student student =	this.hibernateTemplate.get(Student.class, studentid);
	this.hibernateTemplate.delete(student);
		
	}
	
	//updating data
	@Transactional
	public void Updatedata(Student student) {
		
		this.hibernateTemplate.update(student);
	}

}
