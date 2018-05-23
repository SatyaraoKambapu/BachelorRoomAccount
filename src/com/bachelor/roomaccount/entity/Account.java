package com.bachelor.roomaccount.entity;

import java.util.Date;
import java.util.List;

import com.bachelor.roomaccount.common.IAccount;
import com.bachelor.roomaccount.common.ITransaction;

/**
 * Account can be maintained by every end of the month
 * 
 * @author skambapu
 *
 */
public class Account implements IAccount {
	private long id;
	private List<ITransaction> transactionsCalculatedPerMonth;
	private Date accountDate;
	private int totalPersonsInRoom;
	private double eachShare;
	private List<Person> totalPersonsForAnAccount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.IAccount#getId()
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
	 * @see com.bachelor.roomaccount.entity.IAccount#
	 * getTransactionsCalculatedPerMonth()
	 */
	@Override
	public List<ITransaction> getTransactionsCalculatedPerMonth() {
		return transactionsCalculatedPerMonth;
	}

	public void setTransactionsCalculatedPerMonth(List<ITransaction> transactionsCalculatedPerMonth) {
		this.transactionsCalculatedPerMonth = transactionsCalculatedPerMonth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.IAccount#getAccountDate()
	 */
	@Override
	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	@Override
	public int getTotalPersonsInRoom() {
		return totalPersonsInRoom;
	}

	public void setTotalPersonsInRoom(int totalPersonsInRoom) {
		this.totalPersonsInRoom = totalPersonsInRoom;
	}

	@Override
	public double getEachShare() {
		return eachShare;
	}

	public void setEachShare(double eachShare) {
		this.eachShare = eachShare;
	}

	@Override
	public List<Person> getTotalPersonsForAnAccount() {
		return totalPersonsForAnAccount;
	}

	public void setTotalPersonsForAnAccount(List<Person> totalPersonsForAnAccount) {
		this.totalPersonsForAnAccount = totalPersonsForAnAccount;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", transactionsCalculatedPerMonth=" + transactionsCalculatedPerMonth
				+ ", accountDate=" + accountDate + ", totalPersonsInRoom=" + totalPersonsInRoom + ", eachShare="
				+ eachShare + ", personsAfterCalculations=" + totalPersonsForAnAccount + "]";
	}

}
