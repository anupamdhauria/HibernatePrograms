package in.ineuron.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProgrammerId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer projId;
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	@Override
	public String toString() {
		return "ProgrammerId [pid=" + pid + ", projId=" + projId + "]";
	}
	
	
}
