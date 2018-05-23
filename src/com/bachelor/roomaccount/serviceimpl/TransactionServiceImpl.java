package com.bachelor.roomaccount.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.bachelor.roomaccount.entity.Person;
import com.bachelor.roomaccount.entity.Transaction;

public class TransactionServiceImpl {

	AtomicInteger atomicInteger = new AtomicInteger(1);

	public Transaction createTransaction(Map<Long, Double> shareByEachPerson, String name, double txnAmount,
			String desc) {
		PersonServiceImpl personImpl = new PersonServiceImpl();
		Transaction transaction = new Transaction();
		transaction.setId(atomicInteger.getAndIncrement());
		transaction.setDescription(desc);
		transaction.setName(name);
		transaction.setAmount(txnAmount);
		transaction.setShareByEachPerson(shareByEachPerson);
		List<Person> personsSpentMoneyBy = personImpl.whoSpentMoneyForTxn(transaction);
		transaction.setPersonsSpentMoneyBy(personsSpentMoneyBy);
		return transaction;
	}

}
