package com.bachelor.roomaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bachelor.roomaccount.common.IAccount;
import com.bachelor.roomaccount.common.ITransaction;
import com.bachelor.roomaccount.entity.Ledger;
import com.bachelor.roomaccount.entity.Transaction;
import com.bachelor.roomaccount.serviceimpl.AccountServiceImpl;
import com.bachelor.roomaccount.serviceimpl.TransactionServiceImpl;

public class TestMain {

	public static void main(String[] args) {
		TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();

		List<ITransaction> transactionsCalculatedPerMonth = new ArrayList<>();
		Map<Long, Double> shareByEachPerson = new HashMap<>(); // map(personId,
																// spentMoneyforTransaction)
		shareByEachPerson.put(11l, Double.valueOf(2000.0));
		shareByEachPerson.put(12l, Double.valueOf(3000.0));
		shareByEachPerson.put(13l, Double.valueOf(0.0));
		shareByEachPerson.put(14l, Double.valueOf(0.0));
		shareByEachPerson.put(15l, Double.valueOf(0.0));

		Map<Long, Double> shareByEachPersonForGroceries = new HashMap<>();
		shareByEachPersonForGroceries.put(11l, Double.valueOf(8000.0));
		shareByEachPersonForGroceries.put(12l, Double.valueOf(0.0));
		shareByEachPersonForGroceries.put(13l, Double.valueOf(0.0));
		//shareByEachPersonForGroceries.put(14l, Double.valueOf(0.0));
		shareByEachPersonForGroceries.put(15l, Double.valueOf(0.0));
		Transaction transaction1 = transactionServiceImpl.createTransaction(shareByEachPerson, "PaytoCook", 5000,
				"Given money for Cook");
		Transaction transaction2 = transactionServiceImpl.createTransaction(shareByEachPersonForGroceries, "Groceries",
				8000, "Bought groceries");

		transactionsCalculatedPerMonth.add(transaction1);
		transactionsCalculatedPerMonth.add(transaction2);
		IAccount account = new AccountServiceImpl().createAccountforCurrent(transactionsCalculatedPerMonth);
		Ledger ledger = new Ledger();
		ledger.generateFinalReport(account);
		System.out.println(ledger.getFinalLedgerReport());
	}
}
