package io.kosmocat.hedera.restcontrollers.incomes;

import io.kosmocat.hedera.entities.incomes.IncomeType;
import io.kosmocat.hedera.repositories.incomes.IncomeTypeRepository;
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
@RequestMapping("/api/income-type")
@Slf4j
@RequiredArgsConstructor
public class IncomeTypeRestController {

    private final IncomeTypeRepository incomeTypeRepository;

    @PostMapping
    public ResponseEntity<IncomeType> addNew(@RequestBody IncomeType incomeType) {
        log.info("[REST] Adding new income type: {}", incomeType);
        return new ResponseEntity<>(incomeTypeRepository.save(incomeType), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<IncomeType>> getAllFromUser(@RequestParam Long userId) {
        log.info("[REST] Get all income types of user: {}", userId);
        return new ResponseEntity<>(incomeTypeRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<IncomeType> update(@RequestBody IncomeType incomeType) {
        log.info("[REST] Updating income type: {}", incomeType);
        return new ResponseEntity<>(incomeTypeRepository.save(incomeType), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("[REST] Deleting income type id: {}", id);
        incomeTypeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
