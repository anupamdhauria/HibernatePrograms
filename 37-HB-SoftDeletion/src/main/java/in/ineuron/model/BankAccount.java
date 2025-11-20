package in.ineuron.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@SuppressWarnings("deprecation")
@Entity
@Table(name="bankaccount_filter")

@SQLDelete(sql = "UPDATE bankaccount_filter  SET status='closed' WHERE accno=?")
@Where(clause ="status <> 'closed' AND status <> 'blocked'")
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
