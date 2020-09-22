package com.srx.financial.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transactions database table.
 * 
 */
@Entity
@Table(name="transactions")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRANSACTION_ID")
	private int transactionId;

	private BigDecimal amount;

	@Column(name="`COMMENT`")
	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;

	//bi-directional many-to-one association to Company
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Company customer;

	//bi-directional many-to-one association to Company
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="PROVIDER_ID")
	private Company provider;

	//bi-directional many-to-one association to TransactionType
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="TRANSACTION_TYPE_ID")
	private TransactionType transactionType;

	public Transaction() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Company getCustomer() {
		return customer;
	}

	public void setCustomer(Company customer) {
		this.customer = customer;
	}

	public Company getProvider() {
		return provider;
	}

	public void setProvider(Company provider) {
		this.provider = provider;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}