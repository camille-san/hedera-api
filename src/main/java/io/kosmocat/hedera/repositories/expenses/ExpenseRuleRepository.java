package io.kosmocat.hedera.repositories.expenses;

import io.kosmocat.hedera.entities.expenses.ExpenseRule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRuleRepository extends CrudRepository<ExpenseRule, Long> {

    List<ExpenseRule> findAllByUserId(Long userId);

}
