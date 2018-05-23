package com.bachelor.roomaccount.common;

import java.util.List;
import java.util.Map;

import com.bachelor.roomaccount.entity.Person;

public interface ITransaction {

	long getId();

	String getName();

	List<Person> getPersonsSharedBy();

	List<Person> getPersonsSpentMoneyBy();

	double getAmount();

	String getDescription();

	Map<Long, Double> getShareByEachPerson();

}