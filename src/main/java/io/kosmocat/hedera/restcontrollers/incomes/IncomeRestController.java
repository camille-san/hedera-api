package io.kosmocat.hedera.restcontrollers.incomes;

import io.kosmocat.hedera.entities.incomes.Income;
import io.kosmocat.hedera.repositories.incomes.IncomeRepository;
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
@RequestMapping("/api/income")
@Slf4j
@RequiredArgsConstructor
public class IncomeRestController {

    private final IncomeRepository incomeRepository;

    @PostMapping
    public Income addNew(@RequestBody Income income) {
        log.info("[REST] Adding new income: {}", income);
        return incomeRepository.save(income);
    }

    @GetMapping(value = "/user/{userId}/all")
    public List<Income> getAllFromUser(@PathVariable Long userId) {
        log.info("[REST] Get all incomes of user: {}", userId);
        return incomeRepository.findAllByUserId(userId);
    }

    @PutMapping
    public Income update(@RequestBody Income income) {
        log.info("[REST] Updating income: {}", income);
        return incomeRepository.save(income);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        log.info("[REST] Deleting income id: {}", id);
        incomeRepository.deleteById(id);
    }

}
