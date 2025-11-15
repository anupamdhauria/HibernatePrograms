package in.ineuron.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "student")
public class Student_Sequence {

	@Id
	@GenericGenerator(name = "gen1", strategy = "sequence",parameters  = {
			@Parameter(value = "sid_seq", name = "sequence_name"),
			@Parameter(name = "increment_size", value = "1")})   // THIS IS allocationSize})
	@GeneratedValue(generator = "gen1")
	private Integer sid;

	private String sname;

	private String saddress;

	private Double marks;

	public Student_Sequence(String sname, String saddress, Double marks) {
		this.sname = sname;
		this.saddress = saddress;
		this.marks = marks;
	}

	public Student_Sequence() {

		System.out.println("Zero args constructor::Student Model");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
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

}
