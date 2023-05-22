package io.kosmocat.hedera.restcontrollers.expenses;

import io.kosmocat.hedera.entities.expenses.ExpenseType;
import io.kosmocat.hedera.repositories.expenses.ExpenseTypeRepository;
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
@RequestMapping("/api/expense-type")
@Slf4j
@RequiredArgsConstructor
public class ExpenseTypeRestController {

    private final ExpenseTypeRepository expenseTypeRepository;

    @PostMapping
    public ResponseEntity<ExpenseType> addNew(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Adding new expense type: {}", expenseType);
        return new ResponseEntity<>(expenseTypeRepository.save(expenseType), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ExpenseType>> getAllFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all expense types of user: {}", userId);
        return new ResponseEntity<>(expenseTypeRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExpenseType> update(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Updating expense type: {}", expenseType);
        return new ResponseEntity<>(expenseTypeRepository.save(expenseType), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("[REST] Deleting expense type id: {}", id);
        expenseTypeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
