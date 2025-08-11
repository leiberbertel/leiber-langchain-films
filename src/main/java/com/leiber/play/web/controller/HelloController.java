package com.leiber.play.web.controller;

import com.leiber.play.domain.service.LeiberPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;
    private final LeiberPlayAiService leiberPlayAiService;

    public HelloController(@Value("${spring.application.name}") String platform, LeiberPlayAiService leiberPlayAiService) {
        this.leiberPlayAiService = leiberPlayAiService;
        this.platform = platform;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.leiberPlayAiService.generateGreeting(platform);
    }
}
