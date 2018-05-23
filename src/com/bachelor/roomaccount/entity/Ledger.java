package com.bachelor.roomaccount.entity;

import java.util.ArrayList;
import java.util.List;

import com.bachelor.roomaccount.common.IAccount;

public class Ledger {

	private IAccount account;

	private List<Person> finalLedgerReport;

	public List<Person> getFinalLedgerReport() {
		return finalLedgerReport;
	}

	public void setFinalLedgerReport(List<Person> finalLedgerReport) {
		this.finalLedgerReport = finalLedgerReport;
	}

	public IAccount getAccount() {
		return account;
	}

	public void setAccount(IAccount account) {
		this.account = account;
	}

	public void generateFinalReport(IAccount account) {
		List<Person> personsSharedBy = account.getTotalPersonsForAnAccount();
		finalLedgerReport = new ArrayList<>();
		for (Person person : personsSharedBy) {
			double eachShare = person.getEachShare();
			double totalMoneySpent = person.getTotalMoneySpent(account);
			if (eachShare < totalMoneySpent) {
				person.setCredit(totalMoneySpent - eachShare);
			} else {
				person.setDebit(eachShare - totalMoneySpent);
			}
			finalLedgerReport.add(person);
		}
	}

}
