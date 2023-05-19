package io.kosmocat.hedera.repositories.incomes;

import io.kosmocat.hedera.entities.incomes.Income;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Long> {

    List<Income> findAllByUserId(Long userId);

}
