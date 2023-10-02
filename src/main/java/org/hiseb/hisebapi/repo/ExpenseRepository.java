package org.hiseb.hisebapi.repo;

import org.hiseb.hisebapi.entity.Expense;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {
}
