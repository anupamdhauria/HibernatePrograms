package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="chequepayment_noparent")
public class ChequePayment extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer chequeNo;
	private String chequeType;
	private LocalDate expiryDate;

	public Integer getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Integer chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return super.toString()+" ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				+ "]";
	}

}
