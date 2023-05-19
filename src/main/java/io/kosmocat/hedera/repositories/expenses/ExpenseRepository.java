package io.kosmocat.hedera.repositories.expenses;

import io.kosmocat.hedera.entities.expenses.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    List<Expense> findAllByUserId(Long userId);

}
