package com.bachelor.roomaccount.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bachelor.roomaccount.common.ITransaction;
import com.bachelor.roomaccount.entity.Person;

public class PersonServiceImpl {

	public Person createPerson(long id, String name) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		return person;
	}

	public List<Person> getTotalPersons() {
		List<Person> list = new ArrayList<>();
		Person person1 = createPerson(11, "Satya");
		Person person2 = createPerson(12, "Bhanu");
		Person person3 = createPerson(13, "Sathish");
		Person person4 = createPerson(14, "Udhay");
		Person person5 = createPerson(15, "Ajith");
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		list.add(person5);
		return list;
	}

	public Person getPerson(long personId) {
		for (Person person : getTotalPersons()) {
			if (personId == person.getId()) {
				return person;
			}
		}
		return null;

	}

	public List<Person> whoSpentMoneyForTxn(ITransaction transaction) {
		List<Person> personsSpentMoneyBy = new ArrayList<>();
		Set<Entry<Long, Double>> entrySets = transaction.getShareByEachPerson().entrySet();
		for (Entry<Long, Double> entry : entrySets) {
			Person person = getPerson(entry.getKey());
			Map<Long, Double> shareByeachTransaction = new HashMap<>();
			shareByeachTransaction.put(transaction.getId(), Double.valueOf(entry.getValue()));
			person.setShareByeachTransaction(shareByeachTransaction);
			personsSpentMoneyBy.add(person);
		}
		return personsSpentMoneyBy;
	}

}
