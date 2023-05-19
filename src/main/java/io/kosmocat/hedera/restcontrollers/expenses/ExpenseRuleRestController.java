package io.kosmocat.hedera.restcontrollers.expenses;

import io.kosmocat.hedera.entities.expenses.ExpenseRule;
import io.kosmocat.hedera.repositories.expenses.ExpenseRuleRepository;
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
@RequestMapping("/api/expense-rule")
@Slf4j
@RequiredArgsConstructor
public class ExpenseRuleRestController {

    private final ExpenseRuleRepository expenseRuleRepository;

    @PostMapping
    public ExpenseRule addNew(@RequestBody ExpenseRule expenseRule) {
        log.info("[REST] Adding new expense rule: {}", expenseRule);
        return expenseRuleRepository.save(expenseRule);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<ExpenseRule> getAllFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all expense rules of user: {}", userId);
        return expenseRuleRepository.findAllByUserId(userId);
    }

    @PutMapping
    public ExpenseRule update(@RequestBody ExpenseRule expenseRule) {
        log.info("[REST] Updating expense rule: {}", expenseRule);
        return expenseRuleRepository.save(expenseRule);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("[REST] Deleting expense rule id: {}", id);
        expenseRuleRepository.deleteById(id);
    }

}
