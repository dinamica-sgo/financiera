package com.srx.financial.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the fees database table.
 * 
 */
@Entity
@Table(name="fees")
@NamedQuery(name="Fee.findAll", query="SELECT f FROM Fee f")
public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FEE_ID")
	private int feeId;

	private BigDecimal amortization;

	private BigDecimal amount;

	private BigDecimal balance;

	private BigDecimal late;

	public BigDecimal getLate() {
		return late;
	}

	public void setLate(BigDecimal late) {
		this.late = late;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="DUE_DATE")
	private Date dueDate;

	private BigDecimal interest;

	@Column(name="CURRENT_QUOTA")
	private int currentQuota;

	private int quotas;

	//bi-directional many-to-one association to Company
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	public Fee() {
	}

	public int getFeeId() {
		return this.feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public BigDecimal getAmortization() {
		return this.amortization;
	}

	public void setAmortization(BigDecimal amortization) {
		this.amortization = amortization;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getInterest() {
		return this.interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public int getCurrentQuota() {
		return currentQuota;
	}

	public void setCurrentQuota(int currentQuota) {
		this.currentQuota = currentQuota;
	}

	public int getQuotas() {
		return this.quotas;
	}

	public void setQuotas(int quotas) {
		this.quotas = quotas;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}