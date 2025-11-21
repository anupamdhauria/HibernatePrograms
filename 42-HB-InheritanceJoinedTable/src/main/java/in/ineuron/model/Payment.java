package in.ineuron.model;

import java.io.Serializable;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_mutilpletable")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "payment_mode",discriminatorType = DiscriminatorType.STRING)
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer pid;
	private Double amount;
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amount=" + amount + "]";
	}
	
	

}
