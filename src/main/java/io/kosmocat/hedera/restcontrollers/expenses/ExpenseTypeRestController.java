package io.kosmocat.hedera.restcontrollers.expenses;

import io.kosmocat.hedera.entities.expenses.ExpenseType;
import io.kosmocat.hedera.repositories.expenses.ExpenseTypeRepository;
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
@RequestMapping("/api/expense-type")
@Slf4j
@RequiredArgsConstructor
public class ExpenseTypeRestController {

    private final ExpenseTypeRepository expenseTypeRepository;

    @PostMapping
    public ExpenseType addNew(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Adding new expense type: {}", expenseType);
        return expenseTypeRepository.save(expenseType);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<ExpenseType> getAllFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all expense types of user: {}", userId);
        return expenseTypeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public ExpenseType update(@RequestBody ExpenseType expenseType) {
        log.info("[REST] Updating expense type: {}", expenseType);
        return expenseTypeRepository.save(expenseType);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("[REST] Deleting expense type id: {}", id);
        expenseTypeRepository.deleteById(id);
    }

}
