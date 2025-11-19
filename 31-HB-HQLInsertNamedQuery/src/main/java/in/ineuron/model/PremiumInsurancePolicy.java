package in.ineuron.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="HQL_TRANSFER_QUERY",query="INSERT INTO in.ineuron.model.PremiumInsurancePolicy (policyNo,policyName,policyType,company,tenure)SELECT i.policyNo,i.policyName,i.policyType,i.company,i.tenure FROM in.ineuron.model.InsurancePolicy as i WHERE i.tenure>=:minTenure ")
public class PremiumInsurancePolicy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer policyNo;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;
	
	
	@Override
	public String toString() {
		return "PremiumInsurancePolicy [policyNo=" + policyNo + ", policyName=" + policyName + ", policyType=" + policyType
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
