package io.kosmocat.hedera.restcontrollers.incomes;

import io.kosmocat.hedera.entities.incomes.IncomeRule;
import io.kosmocat.hedera.repositories.incomes.IncomeRuleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/income-rule")
@Slf4j
@RequiredArgsConstructor
public class IncomeRuleRestController {

    private final IncomeRuleRepository incomeRuleRepository;

    @PostMapping
    public IncomeRule addNew(@RequestBody IncomeRule incomeRule) {
        log.info("[REST] Adding new income rule: {}", incomeRule);
        return incomeRuleRepository.save(incomeRule);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<IncomeRule> getAllFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all income rules of user: {}", userId);
        return incomeRuleRepository.findAllByUserId(userId);
    }

    @PutMapping
    public IncomeRule update(@RequestBody IncomeRule incomeRule) {
        log.info("[REST] Updating income rule: {}", incomeRule);
        return incomeRuleRepository.save(incomeRule);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("[REST] Deleting income rule id: {}", id);
        incomeRuleRepository.deleteById(id);
    }

}
