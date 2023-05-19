package io.kosmocat.hedera.restcontrollers;

import io.kosmocat.hedera.entities.Periodicity;
import io.kosmocat.hedera.entities.expenses.ExpenseType;
import io.kosmocat.hedera.entities.incomes.IncomeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utils")
@Slf4j
public class UtilsRestController {

    @GetMapping("/periodicities")
    public Periodicity[] getPeriodicities() {
        return Periodicity.values();
    }

}
