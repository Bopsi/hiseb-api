package org.hiseb.hisebapi.controller;

import java.util.List;

import org.hiseb.hisebapi.entity.Expense;
import org.hiseb.hisebapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("")
	List<Expense> getAll() {
		return this.expenseService.read();
	}

	@PostMapping("")
	void save(@RequestBody Expense expense) {
		this.expenseService.create(expense);
	}

	@PutMapping("/{id}")
	void update(@PathVariable(name = "id") long id, @RequestBody Expense expense) throws Exception {
		this.expenseService.update(id, expense);
	}

	@DeleteMapping("/{id}")
	void update(@PathVariable(name = "id") long id) throws Exception {
		this.expenseService.delete(id);
	}

	@PostMapping("/search")
	List<Expense> search(@RequestParam(name = "query") String criteria) {
		return this.expenseService.search(criteria);
	}

	@GetMapping("/test")
	HttpStatus health() {
		return HttpStatus.OK;
	}
}
