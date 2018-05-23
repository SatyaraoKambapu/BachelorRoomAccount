package com.bachelor.roomaccount.common;

import java.util.Date;
import java.util.List;

import com.bachelor.roomaccount.entity.Person;

public interface IAccount {

	long getId();

	List<ITransaction> getTransactionsCalculatedPerMonth();

	Date getAccountDate();

	double getEachShare();

	int getTotalPersonsInRoom();

	List<Person> getTotalPersonsForAnAccount();

}