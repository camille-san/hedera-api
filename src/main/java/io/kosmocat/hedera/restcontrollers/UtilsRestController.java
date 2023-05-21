package io.kosmocat.hedera.restcontrollers;

import io.kosmocat.hedera.entities.Periodicity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utils")
@Slf4j
public class UtilsRestController {

    @GetMapping("/periodicities")
    public ResponseEntity<Periodicity[]> getPeriodicities() {
        return new ResponseEntity<>(Periodicity.values(), HttpStatus.OK);
    }

}
