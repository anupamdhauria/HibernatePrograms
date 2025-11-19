package in.ineuron.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name="GET_RECORDS_BY_TYPE",query="SELECT policyno,policyname,company FROM insurancepolicy where policytype=?")
public class InsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer policyNo;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	public InsurancePolicy() {
		System.out.println("ZERO ARGS :Hibernate uses internally");
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyNo=" + policyNo + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	public Integer getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
	

}
