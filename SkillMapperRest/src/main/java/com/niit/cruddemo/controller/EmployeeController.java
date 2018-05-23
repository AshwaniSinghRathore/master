package com.niit.cruddemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.cruddemo.dao.EmployeeDAO;
import com.niit.cruddemo.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	
	@Autowired
private EmployeeDAO employeeDAO;
	
	
	/*@GetMapping("/message")
	private String getAllEmployee()
	{
		//List<Employee> 
		return "Hello";
	}*/
	
	
	/*@GetMapping("/message")
	public ResponseEntity<List<String>> getAllEmployee()
	{
		List<String> list=Arrays.asList("robin","divya","naveen","mani");
		if(list!=null)

		{
			return new ResponseEntity<List<String>>(list,HttpStatus.OK);
		
		}
		else
		
			
		
		return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		
	}*/
	
	 
	  
	   @GetMapping("/employee")
	public ResponseEntity<?> getAllEmployee()
	{
		List<Employee> list=employeeDAO.findAll();
		if(list!=null)

		{
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
		}
		else
		
			
		
		return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		
	}
	 
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		boolean status = employeeDAO.addEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	 
	
	
	 
	@PostMapping("/delete/{empid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("emailId") String emailId)
	{
		boolean status = employeeDAO.deleteEmployee(emailId);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	 
	
	
	
	
	 
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> employeeId(@PathVariable("emailId") String emailId)
	{
	Employee employee=employeeDAO.findById(emailId);
		 
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
			}
	 
	
	
	 
	@PostMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
	{
	 
		  
	  employeeDAO.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
			}
	 
	
	/*public boolean validateEmployee(String email,String password);
	 * this is done in EmployeeDAO in backend project and implement in DAO implementation
	 * public boolean validateEmployee(String email,String password)
	 * {
	 * Query query=sessionFactory.getcurrentSession().createQuery("from employee where emailid='"+emailId"' and password='"+password"'")
	 * 
	 * Employee employee = (Employee)query.uniqueQuery();
	 * if(employee!=true)
return true;
else
return false;
	 * 
	 * }
	 * 
	 * now in restAPI code  */
	  @PostMapping("/login")
	  public ResponseEntity<?> loginEmployee(@RequestBody Employee employee)
	  {boolean status=employeeDAO.validateEmployee(employee.getEmpEmail(),employee.getEmpPassword());
	  if(status)
	  {return new ResponseEntity<String>("Invalid credentails",HttpStatus.OK);
	  }
	  else
	  {
	  
	  return new ResponseEntity<String>("Invalid credentails",HttpStatus.NOT_FOUND);
	  }
	  }
}