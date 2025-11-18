package in.ineuron.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class MobileNumberInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private long mobileno;
	private String callerTune;
	
	@Version
	private Integer versionCount;

	public MobileNumberInfo() {
		System.out.println("Zero args constructor::hibernate Using this..");
	}
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}



	public Integer getVersionCount() {
		return versionCount;
	}



	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}



	@Override
	public String toString() {
		return "MobileNumberInfo [cid=" + cid + ", cname=" + cname + ", mobileno=" + mobileno + ", callerTune="
				+ callerTune + ", versionCount=" + versionCount + "]";
	}
	
	
}
