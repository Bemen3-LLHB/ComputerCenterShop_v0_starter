package model;

import main.Logable;
import dao.*;

public class Employee extends Person implements Logable{
	private int employeeId;
	private String password;
	// Simulated RA1 login using a text file, without JDBC or database access.
	private Dao dao = new DaoImplFile();
	
//	public static final int USER = 123;
//	public static final String PASSWORD = "test";
	
	public Employee(String name) {
		super(name);
	}
	
	public Employee(int employeeId, String name, String password) {
		super(name);
		this.employeeId = employeeId;
		this.password = password;
	}
	
	public Employee() {
		super();
	}
	
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param user from application, password from application
	 * @return true if credentials are correct or false if not
	 */
	@Override
	public boolean login(int user, String password) {
//		if (USER == user && PASSWORD.equals(password)) {
//			return true;
//		} 
		boolean success = false;
		
		// connect to file data
		dao.connect();
		
		// get employee data
		if(dao.getEmployee(user, password) != null) {
			success =  true;
		}
		
		// disconnect file data
		dao.disconnect();
		return success;
	}

}
