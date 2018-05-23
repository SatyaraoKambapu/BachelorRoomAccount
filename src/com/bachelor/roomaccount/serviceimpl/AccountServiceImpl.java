package com.bachelor.roomaccount.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bachelor.roomaccount.common.IAccount;
import com.bachelor.roomaccount.common.ITransaction;
import com.bachelor.roomaccount.entity.Account;
import com.bachelor.roomaccount.entity.Person;

public class AccountServiceImpl {
	PersonServiceImpl personImpl = new PersonServiceImpl();

	public IAccount createAccountforCurrent(List<ITransaction> transactionsList) {
		Account account = new Account();
		account.setAccountDate(new Date());
		account.setId(1);
		List<Person> totalPersons = personImpl.getTotalPersons();
		int totalHeadCount = totalPersons.size();
		account.setTotalPersonsForAnAccount(totalPersons);
		account.setTotalPersonsInRoom(totalHeadCount);
		double totalAmountSpentPerMonth = getTotalAmountSpentInMonthForAllPersons(transactionsList, totalPersons);
		double eachShare = totalAmountSpentPerMonth / totalHeadCount;
		updateEachShare(transactionsList, totalPersons, totalAmountSpentPerMonth);
		account.setTransactionsCalculatedPerMonth(transactionsList);
		return account;
	}

	private double getTotalAmountSpentInMonthForAllPersons(List<ITransaction> transactionsList,
			List<Person> totalPersons) {
		double sum = 0;
		for (ITransaction iTransaction : transactionsList) {
			if (totalPersons.size() == iTransaction.getShareByEachPerson().keySet().size()) {
				sum = sum + iTransaction.getAmount();
			}
		}
		return sum;
	}

	private void updateEachShare(List<ITransaction> transactionsList, List<Person> totalPersons,
			double totalAmountSpentPerMonth) {
		for (ITransaction iTransaction : transactionsList) {
			Map<Long, Double> map = iTransaction.getShareByEachPerson();
			Set<Entry<Long, Double>> entrySet = map.entrySet();
			for (Entry<Long, Double> entry : entrySet) {
				for (Person person : totalPersons) {
					Person personInvolved = personImpl.getPerson(entry.getKey());
					if (personInvolved.getId() == person.getId()) {
						double eachShare = person.getEachShare();
						person.setEachShare(eachShare + (iTransaction.getAmount() / entrySet.size()));
					}
				}
			}
		}
	}

}
