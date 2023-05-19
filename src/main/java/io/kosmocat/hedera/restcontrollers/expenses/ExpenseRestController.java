package io.kosmocat.hedera.restcontrollers.expenses;

import io.kosmocat.hedera.entities.expenses.Expense;
import io.kosmocat.hedera.repositories.expenses.ExpenseRepository;
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
@RequestMapping("/api/expense")
@Slf4j
@RequiredArgsConstructor
public class ExpenseRestController {

    private final ExpenseRepository expenseRepository;

    @PostMapping
    public Expense addNew(@RequestBody Expense expense) {
        log.info("[REST] Adding new expense: {}", expense);
        return expenseRepository.save(expense);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<Expense> getAllFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all expenses of user: {}", userId);
        return expenseRepository.findAllByUserId(userId);
    }

    @PutMapping
    public Expense update(@RequestBody Expense expense) {
        log.info("[REST] Updating expense: {}", expense);
        return expenseRepository.save(expense);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("[REST] Deleting expense id: {}", id);
        expenseRepository.deleteById(id);
    }

}
