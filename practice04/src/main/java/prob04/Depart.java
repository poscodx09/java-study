package prob04;

public class Depart extends Employee {
	private String department;
	public Depart(String string, int i, String string2) {
		super(string, i);
		setDepartment(string2);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void print() {
		System.out.println( "이름:" + super.getName() + "연봉:" + super.getSalary() + "부서:" + this.department );
	}
	
	
	

}
