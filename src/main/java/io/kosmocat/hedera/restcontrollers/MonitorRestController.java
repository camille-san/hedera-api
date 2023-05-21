package io.kosmocat.hedera.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MonitorRestController {

    @GetMapping(value = "/monitor/isAlive")
    public ResponseEntity<String> isAlive() {
        return new ResponseEntity<>("Yes I'm alive", HttpStatus.OK);
    }

}
