package org.hiseb.hisebapi.service;

import java.util.ArrayList;
import java.util.List;

import org.hiseb.hisebapi.entity.Expense;
import org.hiseb.hisebapi.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	public void create(Expense expense) {
		this.expenseRepository.save(expense);
	}

	public List<Expense> read() {
		return (List<Expense>) this.expenseRepository.findAll();
	}

	public void update(long id, Expense expense) throws Exception {
		Expense _expense = this.expenseRepository.findById(id).get();
		if (_expense != null) {
			this.expenseRepository.save(expense);
		} else {
			throw new Exception("Tag does not exist");
		}
	}

	public void delete(long id) throws Exception {
		Expense _expense = this.expenseRepository.findById(id).get();
		if (_expense != null) {
			this.expenseRepository.deleteById(id);
		} else {
			throw new Exception("Tag does not exist");
		}
	}

	public List<Expense> search(String criteria) {
		return new ArrayList<Expense>();
	}
}
