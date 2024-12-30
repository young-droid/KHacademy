package edu.kh.oarr.practice.model.vo;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeDepart;
	private String employeePosition;
	private int employeeWage;
	
	
	public Employee() {
		
	}
	
	public Employee(int employeeId, String employeeName, String employeeDepart, 
					String employeePosition, int employWage) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepart = employeeDepart;
		this.employeePosition = employeePosition;
		this.employeeWage = employWage;
	}
	
	
	
	
	
	
	
	// override
	public String toString() {
		return	"사번 : " + employeeId + 
				", 이름 : " + employeeName + 
				", 부서 : " + employeeDepart +
				", 직급 : " + employeePosition + 
				", 급여 : " + employeeWage;
	}
	
	
	
	
	
	
	
	
	// getter / setter
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepart() {
		return employeeDepart;
	}
	public void setEmployeeDepart(String employeeDepart) {
		this.employeeDepart = employeeDepart;
	}
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public int getEmployeeWage() {
		return employeeWage;
	}
	public void setEmployeeWage(int employeeWage) {
		this.employeeWage = employeeWage;
	}

}
