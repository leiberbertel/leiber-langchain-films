package com.leiber.play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface LeiberPlayAiService {

    @UserMessage("""
               Genera un saludo de bienvenida a la plataforma de Gestion de Peliculas {{platform}}
               Usa menos de 120 caracteres y hazlo con el estilo de Alibaba
            """)
    String generateGreeting(@V("platform") String platform);
}
