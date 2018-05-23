package com.niit.cruddemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cruddemo.model.Employee;

@Repository ("employeeDAO")
@Transactional
public class EmployeeDAOImplementation implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> findAll() {

		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public Employee findById(int empId) {
		 
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empId="+empId)
				.uniqueResult();
	}

	public boolean findByName(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public boolean deleteEmployee(int empId) {
		sessionFactory.getCurrentSession().delete(findById(empId));	
		return true;
	}

	public Employee findByName(String empname) {
		return (Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where empname='"+empname+"'").uniqueResult();
				
	
	}

	@Override
	public Employee findById(String emailId) {
		 
		return(Employee)sessionFactory.getCurrentSession()
				.createQuery("from Employee where emailId="+emailId)
				.uniqueResult();
	}

	@Override
	public boolean deleteEmployee(String emailId) {
		sessionFactory.getCurrentSession().delete(findById(emailId));	
		return true;
	}

	@Override
	public boolean validateEmployee(String email, String password) {
		 
		 Query query=sessionFactory.getCurrentSession().createQuery("from employee where emailid='"+email+"' and password='"+password+"'");
		  
		  Employee employee =(Employee)query.uniqueResult();
		  if(employee!=null)
		  
	return true;
	else
	return false;
		 
		
	}

}
