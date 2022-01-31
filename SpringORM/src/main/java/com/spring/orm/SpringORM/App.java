package com.spring.orm.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.SpringORM.dao.StudentDao;

import Entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    ApplicationContext context=	new ClassPathXmlApplicationContext("config.xml");
   StudentDao stu= context.getBean("studentdao", StudentDao.class);
   
   		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   		boolean go = true;
   		while(go) {
   		System.out.println("Press 1 to add new Student");
   		System.out.println("Press 2 to display all Students");
   		System.out.println("Press 3 to get the detail of the desired student");
   		System.out.println("Press 4 to delete Student");
   		System.out.println("Press 6 to Exit");
   		
   		try {
		int selected = 	Integer.parseInt(br.readLine());
		
		switch(selected) {
		
		case 1 : 
			System.out.println("Enter Student id");
			int id = Integer.parseInt(br.readLine());
			System.out.println("Enter Student name");
			String name = br.readLine();
			System.out.println("Enter Student City");
			String city = br.readLine();
			Student student = new Student(id,name,city);
			stu.insert(student);
			
			break;
		
		case 2 :
			
			List<Student> studentlist = stu.getAllStudent();
			for(Student student1: studentlist) {
				System.out.println(student1);
			}
			
			break;
		
		
		case 3 :
			System.out.println("eneter the id of the student ");
			int id2 = Integer.parseInt(br.readLine());
			Student student3 = stu.getstudent(id2);
			System.out.println(student3);
			
			break;
		
		case 4 :
			System.out.println("Enter the id you want to delete");
			int id3 = Integer.parseInt(br.readLine());
			stu.deleteData(id3);
			System.out.println("Deleted successfully");
			break;
		
		
		case 6 :
			go= false;
			break;
		
		
		}	}
				
   			
   			
		 catch (Exception e) {
			System.out.println("Invalid Input, try with another one!!");
			
		}
   		
   		
   		}
   		
    }
}
