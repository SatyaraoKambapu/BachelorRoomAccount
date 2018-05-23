package com.bachelor.roomaccount.entity;

import java.util.List;
import java.util.Map;

import com.bachelor.roomaccount.common.IPerson;
import com.bachelor.roomaccount.common.ITransaction;

public class Transaction implements ITransaction {
	private long id;
	private String name;
	private List<Person> personsSharedBy;
	private List<Person> personsSpentMoneyBy;
	private double amount;
	private String description;
	private Map<Long, Double> shareByEachPerson;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.ITransaction#getId()
	 */
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.ITransaction#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.ITransaction#getPersonsSharedBy()
	 */
	@Override
	public List<Person> getPersonsSharedBy() {
		return personsSharedBy;
	}

	public void setPersonsSharedBy(List<Person> personsSharedBy) {
		this.personsSharedBy = personsSharedBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bachelor.roomaccount.entity.ITransaction#getPersonsSpentMoneyBy()
	 */
	@Override
	public List<Person> getPersonsSpentMoneyBy() {
		return personsSpentMoneyBy;
	}

	public void setPersonsSpentMoneyBy(List<Person> personsSpentMoneyBy) {
		this.personsSpentMoneyBy = personsSpentMoneyBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.ITransaction#getAmount()
	 */
	@Override
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Map<Long, Double> getShareByEachPerson() {
		return shareByEachPerson;
	}

	public void setShareByEachPerson(Map<Long, Double> shareByEachPerson) {
		this.shareByEachPerson = shareByEachPerson;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", name=" + name + ", personsSharedBy=" + personsSharedBy
				+ ", personsSpentMoneyBy=" + personsSpentMoneyBy + ", amount=" + amount + ", description=" + description
				+ "]";
	}

}
