package io.kosmocat.hedera.restcontrollers.incomes;

import io.kosmocat.hedera.entities.incomes.Income;
import io.kosmocat.hedera.repositories.incomes.IncomeRepository;
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
@RequestMapping("/api/income")
@Slf4j
@RequiredArgsConstructor
public class IncomeRestController {

    private final IncomeRepository incomeRepository;

    @PostMapping
    public ResponseEntity<Income> addNew(@RequestBody Income income) {
        log.info("[REST] Adding new income: {}", income);
        return new ResponseEntity<>(incomeRepository.save(income), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Income>> getAllFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all incomes of user: {}", userId);
        return new ResponseEntity<>(incomeRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Income> update(@RequestBody Income income) {
        log.info("[REST] Updating income: {}", income);
        return new ResponseEntity<>(incomeRepository.save(income), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("[REST] Deleting income id: {}", id);
        incomeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
