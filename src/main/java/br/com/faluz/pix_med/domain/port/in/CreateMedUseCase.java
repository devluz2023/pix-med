package br.com.faluz.pix_med.domain.port.in;


import java.math.BigDecimal;

import br.com.faluz.pix_med.domain.entity.MedRequest;

public interface CreateMedUseCase {
    MedRequest execute(String transactionId, BigDecimal amount);
}