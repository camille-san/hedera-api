package io.kosmocat.hedera.repositories.incomes;

import io.kosmocat.hedera.entities.incomes.IncomeType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncomeTypeRepository extends CrudRepository<IncomeType, Long> {

    List<IncomeType> findAllByUserId(Long userId);

}
