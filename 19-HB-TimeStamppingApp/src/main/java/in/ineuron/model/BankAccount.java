package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountNo;
	private String holderName;
	private Double balance;
	private String type;
	
	@CreationTimestamp
	private LocalDateTime accountOpeningDate;
	@UpdateTimestamp
	private LocalDateTime accountUpdationDate;
	
	@Version
	private Integer AccountUpdateCount;

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", holderName=" + holderName + ", balance=" + balance + ", type="
				+ type + ", accountOpeningDate=" + accountOpeningDate + ", accountUpdationDate=" + accountUpdationDate
				+ ", AccountUpdateCount=" + AccountUpdateCount + "]";
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDateTime accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public LocalDateTime getAccountUpdationDate() {
		return accountUpdationDate;
	}

	public void setAccountUpdationDate(LocalDateTime accountUpdationDate) {
		this.accountUpdationDate = accountUpdationDate;
	}

	public Integer getAccountUpdateCount() {
		return AccountUpdateCount;
	}

	public void setAccountUpdateCount(Integer accountUpdateCount) {
		AccountUpdateCount = accountUpdateCount;
	}

	
}
