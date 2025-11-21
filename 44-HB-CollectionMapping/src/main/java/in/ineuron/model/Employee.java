package in.ineuron.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_collection")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Integer eid;
	private String ename;
	private String eaddress;
	
	@ElementCollection
	@CollectionTable(name = "EMP_FRNDS",joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@ListIndexBase(value = 1)
	@OrderColumn(name = "friend_sno")
	@Column(name="friend_list")
	private List<String>friendList;
	
	
	@ElementCollection
	@CollectionTable(name="EMP_MOBILENOS",joinColumns=@JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@Column(name = "mobile_no")
	private Set<Long>mobileNo;
	
	@ElementCollection
	@CollectionTable(name = "EMP_BANK_ACCOUNT",joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@Column(name="bank_accounts")
	@MapKeyColumn(name="bankName",length=10)
	private Map<String,Long>bankAccount;

	
	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEaddress() {
		return eaddress;
	}


	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}


	public List<String> getFriendList() {
		return friendList;
	}


	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}


	public Set<Long> getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Set<Long> mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Map<String, Long> getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(Map<String, Long> bankAccount) {
		this.bankAccount = bankAccount;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friendList=" + friendList
				+ ", mobileNo=" + mobileNo + ", bankAccount=" + bankAccount + "]";
	}
	
	

}
