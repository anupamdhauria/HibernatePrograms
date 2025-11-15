package in.ineuron.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Student {
	
	@Id
	@GenericGenerator(name="gen1",strategy="in.ineuron.idgenerator.MyIdGen")
	@GeneratedValue(generator="gen1")
	private String sid;
	
	private String sname;
	
	private String saddress;
	
	private Double marks;

	
	public Student(String sname, String saddress, Double marks) {
		this.sname = sname;
		this.saddress = saddress;
		this.marks = marks;
	}

	public Student() {
		
	}
	
	
	
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", marks=" + marks + "]";
	}

	

	
	
}
