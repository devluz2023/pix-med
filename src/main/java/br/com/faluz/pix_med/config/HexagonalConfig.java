package br.com.faluz.pix_med.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.faluz.pix_med.domain.port.out.MedRequestRepository;
import br.com.faluz.pix_med.domain.service.CreateMedService;

@Configuration
public class HexagonalConfig {

    @Bean
    public CreateMedService createMedService(MedRequestRepository repository) {
        return new CreateMedService(repository);
    }
}