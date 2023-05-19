package io.kosmocat.hedera;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class HederaApplication implements CommandLineRunner {

    private final Environment env;

    public static void main(String[] args) {
        SpringApplication.run(HederaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Spring profiles used: {}", Arrays.asList(env.getActiveProfiles()));
        log.info("Datasource url used: {}", env.getProperty("spring.datasource.url"));
        log.info("Datasource user used: {}", env.getProperty("spring.datasource.username"));
    }

}
