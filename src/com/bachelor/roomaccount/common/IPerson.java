package com.bachelor.roomaccount.common;

import java.util.Map;

public interface IPerson {

	long getId();

	String getName();

	double getCredit();

	double getDebit();

	double getTotalMoneySpentPerMonth();

	Map<Long, Double> getShareByeachTransaction();

	double getEachShare();

}