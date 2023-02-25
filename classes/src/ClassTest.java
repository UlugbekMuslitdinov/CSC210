import java.util.ArrayList;
import java.util.List;

public class ClassTest {

	public static void main(String[] args) {
		List<Employee> elist = new ArrayList<>();
		
		Manager m1 = new Manager("Tom Jones", 2479, "2/22/1991", 40000.0);
		Manager m2 = new Manager("Jan Macy", 8976, "9/14/2000", 80000.0);
		
		elist.add(m1);
		elist.add(m2);
		
		SalesPerson sp1 = new SalesPerson("Alice Fay", 2334, "5/12/1995", 16.5);
		sp1.setSalary(60000.0f);
	}

}

class Manager extends Employee {
	private double salary;
	
	public Manager (String nm, int id, String bd, double salary) {
		super(nm, id, bd);
		this.salary = salary;
	}
	
	public double Pay() {
		return this.salary;
	}
}

class SalesPerson extends Employee{
	private double salary;
	public SalesPerson(String nm, int id, String bd, double salary) {
		super(nm, id, bd);
		this.salary = salary;
	}
	
	public void setSalary(float f) {
		this.salary = f;		
	}

	public double Pay() {return this.salary;}
}

abstract class Employee {
	private String name;
	private int id;
	private Birthday bday;
	
	public Employee (String nm, int id, String bd) {
		name = nm;
		this.id = id;
		bday = new Birthday(bd);
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Birthday getBday() {return bday;}
	public void setBday(Birthday bday) {this.bday = bday;}
	
	abstract double Pay();
	
	public String toString() {
		return name + '\t' + id +'\t' + bday + '\t' + Pay();
	}
}

class Birthday {
	private int month;
	private int day;
	private int year;
	
	public Birthday() {}
	public Birthday(String bdstr) {
		String[] s = bdstr.split("/");
		month = Integer.parseInt(s[0]);
		day = Integer.parseInt(s[1]);
		year = Integer.parseInt(s[2]);
	}
	
	public int getMonth() {return month;}
	public void setMonth(int month) {this.month = month;}
	public int getDay () {return day;};
	public void setDay(int day) {this.day = day;}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	
	public String toString() {
		return String.valueOf(month) + '/' + day + '/' + year;
	}
}
