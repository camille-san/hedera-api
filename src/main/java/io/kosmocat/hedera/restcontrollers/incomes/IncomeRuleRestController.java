package io.kosmocat.hedera.restcontrollers.incomes;

import io.kosmocat.hedera.entities.incomes.IncomeRule;
import io.kosmocat.hedera.repositories.incomes.IncomeRuleRepository;
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
@RequestMapping("/api/income-rule")
@Slf4j
@RequiredArgsConstructor
public class IncomeRuleRestController {

    private final IncomeRuleRepository incomeRuleRepository;

    @PostMapping
    public ResponseEntity<IncomeRule> addNew(@RequestBody IncomeRule incomeRule) {
        log.info("[REST] Adding new income rule: {}", incomeRule);
        return new ResponseEntity<>(incomeRuleRepository.save(incomeRule), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<IncomeRule>> getAllFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all income rules of user: {}", userId);
        return new ResponseEntity<>(incomeRuleRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<IncomeRule> update(@RequestBody IncomeRule incomeRule) {
        log.info("[REST] Updating income rule: {}", incomeRule);
        return new ResponseEntity<>(incomeRuleRepository.save(incomeRule), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("[REST] Deleting income rule id: {}", id);
        incomeRuleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
