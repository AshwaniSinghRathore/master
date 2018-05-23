package com.niit.cruddemo;

import static org.junit.Assert.assertEquals;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.cruddemo.config.AppContext;
import com.niit.cruddemo.model.Employee;
import com.niit.cruddemo.service.EmployeeService;
 
 @RunWith(SpringRunner.class)
 @SpringJUnitConfig(classes=AppContext.class)
public class TestEmployee {

	 @Autowired
	 private EmployeeService employeeService;
	 
	 @Before
	 public void setup()
	 {
		// employeeService = new EmployeeServiceImplementation();
		 if(employeeService.findEmployeesByName("Ashwani")!=null)
		 {
			 
			 employeeService.deleteEmployee(employeeService.findEmployeesByName("Robin").getEmpId());
			}
			
			if(employeeService.findEmployeesByName("Ashwani")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Ashwani").getEmpId());
			}
			if(employeeService.findEmployeesByName("Chris")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Chris").getEmpId());
			}
			
			Employee emp1=new Employee();
			//emp1.setEmpId(10);

emp1.setEmpName("Divya");
emp1.setEmpPassword("divya");
		emp1.setEmpAddress("kanpur");
		emp1.setEmpEmail("div@gmail.com");
		emp1.setEmpMobileNo(9876543);
	employeeService.addEmployee(emp1);
			Employee emp2=new Employee();
			 
	 }
	 
	 @After
		public void teardown() {
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Robin").getEmpId());
			employeeService.deleteEmployee(employeeService.findEmployeesByName("Ashwani").getEmpId());
			if(employeeService.findEmployeesByName("Robin")!=null) {
				employeeService.deleteEmployee(employeeService.findEmployeesByName("Robin").getEmpId());
			}
			
		}
	 
	 
	 @Test
		public void testAddEmployee() {
			
			Employee emp=new Employee();
			emp.setEmpName("Divya1");
			emp.setEmpPassword("divya");
					emp.setEmpAddress("kanpur");
					emp.setEmpEmail("diva@gmail.com");
					emp.setEmpMobileNo(9876543);
			assertEquals(true, employeeService.addEmployee(emp));
					
		}
		
		@Test
		(expected=ConstraintViolationException.class)
		public void testAddEmployeeFailure() {
			
			Employee emp=new Employee();
			 emp.setEmpPassword("robn");
			
			
			assertEquals(false, employeeService.addEmployee(emp));
					
		}

	 
	 
	 
	 
	 
	 
	
	
	 
}
