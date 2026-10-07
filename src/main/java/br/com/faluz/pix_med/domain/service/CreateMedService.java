package br.com.faluz.pix_med.domain.service;


import java.math.BigDecimal;

import br.com.faluz.pix_med.domain.entity.MedRequest;
import br.com.faluz.pix_med.domain.port.in.CreateMedUseCase;
import br.com.faluz.pix_med.domain.port.out.MedRequestRepository;

public class CreateMedService implements CreateMedUseCase {

    private final MedRequestRepository repository;

    public CreateMedService(MedRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedRequest execute(String transactionId, BigDecimal amount) {
        MedRequest med = new MedRequest(transactionId, amount);
        // Aqui entrariam validações de regras de negócio específicas do MED
        return repository.save(med);
    }
}