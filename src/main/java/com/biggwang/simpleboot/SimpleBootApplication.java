package com.biggwang.simpleboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@SpringBootApplication
public class SimpleBootApplication {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootApplication.class, args);
    }

    @GetMapping("/biggwang")
    public String hello() {
        String now = LocalDateTime.now().toString();
        List<User> userList = (List) userRepository.findAll();
        log.info("############### now: {}", now);
        log.info("############### userList: {}", userList);
        return String.format("%s <br> %s", now, userList);
    }
}
