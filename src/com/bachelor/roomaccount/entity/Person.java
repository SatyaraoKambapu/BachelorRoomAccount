package com.bachelor.roomaccount.entity;

import java.util.List;
import java.util.Map;

import com.bachelor.roomaccount.common.IAccount;
import com.bachelor.roomaccount.common.IPerson;
import com.bachelor.roomaccount.common.ITransaction;

public class Person implements IPerson {
	private long id;
	private String name;
	private double credit;
	private double debit;
	private double totalMoneySpentPerMonth;
	private Map<Long, Double> shareByeachTransaction;
	private double eachShare;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.IPerson#getId()
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
	 * @see com.bachelor.roomaccount.entity.IPerson#getName()
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
	 * @see com.bachelor.roomaccount.entity.IPerson#getCredit()
	 */
	@Override
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.IPerson#getDebit()
	 */
	@Override
	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bachelor.roomaccount.entity.IPerson#getTotalMoneySpentPerMonth()
	 */
	@Override
	public double getTotalMoneySpentPerMonth() {
		return totalMoneySpentPerMonth;
	}

	public void setTotalMoneySpentPerMonth(double totalMoneySpentPerMonth) {
		this.totalMoneySpentPerMonth = totalMoneySpentPerMonth;
	}

	@Override
	public Map<Long, Double> getShareByeachTransaction() {
		return shareByeachTransaction;
	}

	public void setShareByeachTransaction(Map<Long, Double> shareByeachTransaction) {
		this.shareByeachTransaction = shareByeachTransaction;
	}

	public double getTotalMoneySpent(IAccount account) {
		double totalSpent = 0.0;
		List<ITransaction> totalTrans = account.getTransactionsCalculatedPerMonth();
		for (ITransaction iTransaction : totalTrans) {
			for (IPerson person : iTransaction.getPersonsSpentMoneyBy()) {
				if (person.getId() == this.getId()) {
					Map<Long, Double> map = person.getShareByeachTransaction();
					totalSpent += map.get(iTransaction.getId()).doubleValue();
				}
			}
		}
		this.setTotalMoneySpentPerMonth(totalSpent);
		return totalSpent;
	}

	@Override
	public double getEachShare() {
		return eachShare;
	}

	public void setEachShare(double eachShare) {
		this.eachShare = eachShare;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", credit=" + credit + ", debit=" + debit
				+ ", totalMoneySpentPerMonth=" + totalMoneySpentPerMonth + "]";
	}

}
