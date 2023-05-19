package io.kosmocat.hedera.repositories.incomes;

import io.kosmocat.hedera.entities.incomes.IncomeRule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRuleRepository extends CrudRepository<IncomeRule, Long> {

    List<IncomeRule> findAllByUserId(Long userId);

}
