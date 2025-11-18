package in.ineuron.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ProgrammerInfo {

	@EmbeddedId
	private ProgrammerId id;
	private String pname;
	private String projName;
	private Integer deptNo;
	@Override
	public String toString() {
		return "ProgrammerInfo [id=" + id + ", pnmae=" + pname + ", projName=" + projName + ", deptNo=" + deptNo + "]";
	}
	public ProgrammerId getId() {
		return id;
	}
	public void setId(ProgrammerId id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	
	
	
}
