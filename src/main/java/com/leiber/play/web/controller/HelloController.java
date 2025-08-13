package com.leiber.play.web.controller;

import com.leiber.play.domain.service.LeiberPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hola", description = "Operaciones de saludo al usuario")
public class HelloController {

    private final String platform;
    private final LeiberPlayAiService leiberPlayAiService;

    public HelloController(@Value("${spring.application.name}") String platform, LeiberPlayAiService leiberPlayAiService) {
        this.leiberPlayAiService = leiberPlayAiService;
        this.platform = platform;
    }

    @GetMapping("/hello")
    @Operation(
            summary = "Retorna una cadena con un saludo divertido con el nombre del sistema"
    )
    public String hello() {
        return this.leiberPlayAiService.generateGreeting(platform);
    }
}
