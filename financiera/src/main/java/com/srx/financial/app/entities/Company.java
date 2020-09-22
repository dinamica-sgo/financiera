package com.srx.financial.app.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPANY_ID")
	private int companyId;

	@Column(name="COMPANY_CODE")
	private BigInteger companyCode;

	@Column(name="COMPANY_TYPE")
	private String companyType;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private BigInteger mobile;

	private String picture;

	private String provider;

	@Column(name="PROVIDER_TYPE")
	private String providerType;

	//bi-directional many-to-one association to Address
	@JsonBackReference
	@OneToMany(mappedBy="company")
	private Set<Address> addresses;

	//bi-directional many-to-one association to Branch
	@JsonBackReference
	@OneToMany(mappedBy="company")
	private Set<Branch> branches;

	//bi-directional many-to-one association to Fee
	@JsonBackReference
	@OneToMany(mappedBy="company")
	private Set<Fee> fees;

	//bi-directional many-to-one association to Transaction
	@JsonBackReference
	@OneToMany(mappedBy="provider")
	private Set<Transaction> transactionsByProvider;

	//bi-directional many-to-one association to Transaction
	@JsonBackReference
	@OneToMany(mappedBy="customer")
	private Set<Transaction> transactionsByCustomer;
	
	//bi-driection many-to-one association to User
	@JsonBackReference
	@OneToMany(mappedBy="company")
	private Set<User> users;

	public Company() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public BigInteger getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(BigInteger companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobile() {
		return this.mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderType() {
		return this.providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCompany(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCompany(null);

		return address;
	}

	public Set<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setCompany(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setCompany(null);

		return branch;
	}

	public Set<Fee> getFees() {
		return this.fees;
	}

	public void setFees(Set<Fee> fees) {
		this.fees = fees;
	}

	public Fee addFee(Fee fee) {
		getFees().add(fee);
		fee.setCompany(this);

		return fee;
	}

	public Fee removeFee(Fee fee) {
		getFees().remove(fee);
		fee.setCompany(null);

		return fee;
	}

	public Set<Transaction> getTransactionsByProvider() {
		return this.transactionsByProvider;
	}

	public void setTransactionsByProvider(Set<Transaction> transactionsByProvider) {
		this.transactionsByProvider = transactionsByProvider;
	}

	public Transaction addTransactionsByProvider(Transaction transactionsByProvider) {
		getTransactionsByProvider().add(transactionsByProvider);
		transactionsByProvider.setProvider(this);

		return transactionsByProvider;
	}

	public Transaction removeTransactionsByProvider(Transaction transactionsByProvider) {
		getTransactionsByProvider().remove(transactionsByProvider);
		transactionsByProvider.setProvider(null);

		return transactionsByProvider;
	}

	public Set<Transaction> getTransactionsByCustomer() {
		return this.transactionsByCustomer;
	}

	public void setTransactionsByCustomer(Set<Transaction> transactionsByCustomer) {
		this.transactionsByCustomer = transactionsByCustomer;
	}

	public Transaction addTransactionsByCustomer(Transaction transactionsByCustomer) {
		getTransactionsByCustomer().add(transactionsByCustomer);
		transactionsByCustomer.setCustomer(this);

		return transactionsByCustomer;
	}

	public Transaction removeTransactionsByCustomer(Transaction transactionsByCustomer) {
		getTransactionsByCustomer().remove(transactionsByCustomer);
		transactionsByCustomer.setCustomer(null);

		return transactionsByCustomer;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public User addUser(User user) {
		getUsers().add(user);
		user.setCompany(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCompany(null);

		return user;
	}
	

}