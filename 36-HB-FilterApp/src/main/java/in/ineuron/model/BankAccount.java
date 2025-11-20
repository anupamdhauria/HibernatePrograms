package in.ineuron.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="bankaccount_filter")
@FilterDef(name = "FILTER_BANKACCOUNT_STATUS",parameters = {
		@ParamDef(type=String.class,name="accType1"),
		@ParamDef(type=String.class,name="accType2")}
		
)

@Filter(name = "FILTER_BANKACCOUNT_STATUS",condition ="status <> :accType1 AND status <> :accType2")
public class BankAccount {

	@Id
	private Integer accno;
	@Column(name="holdername")
	private String holderName;
	private Double balance;
	private String status;
	
	static {
		System.out.println("BankAccount Object is loading...");
	}
	
	public BankAccount() {
		System.out.println("BankAccont Object is used by Hibernate..");
	}
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	public Integer getAccno() {
		return accno;
	}
	public void setAccno(Integer accno) {
		this.accno = accno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
