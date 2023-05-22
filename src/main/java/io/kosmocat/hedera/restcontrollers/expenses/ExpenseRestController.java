package io.kosmocat.hedera.restcontrollers.expenses;

import io.kosmocat.hedera.entities.expenses.Expense;
import io.kosmocat.hedera.repositories.expenses.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@Slf4j
@RequiredArgsConstructor
public class ExpenseRestController {

    private final ExpenseRepository expenseRepository;

    @PostMapping
    public ResponseEntity<Expense> addNew(@RequestBody Expense expense) {
        log.info("[REST] Adding new expense: {}", expense);
        return new ResponseEntity<>(expenseRepository.save(expense), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Expense>> getAllFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all expenses of user: {}", userId);
        return new ResponseEntity<>(expenseRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Expense> update(@RequestBody Expense expense) {
        log.info("[REST] Updating expense: {}", expense);
        return new ResponseEntity<>(expenseRepository.save(expense), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        log.info("[REST] Deleting expense id: {}", id);
        expenseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
