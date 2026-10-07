package br.com.faluz.pix_med.adapter.in.web;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faluz.pix_med.adapter.in.web.dto.MedRequestDto;
import br.com.faluz.pix_med.domain.entity.MedRequest;
import br.com.faluz.pix_med.domain.port.in.CreateMedUseCase;

@RestController
@RequestMapping("/api/v1/med")
public class MedController {

    private final CreateMedUseCase createMedUseCase;

    public MedController(CreateMedUseCase createMedUseCase) {
        this.createMedUseCase = createMedUseCase;
    }

    @PostMapping
    public ResponseEntity<MedRequest> create(@RequestBody MedRequestDto dto) {
        MedRequest result = createMedUseCase.execute(dto.getTransactionId(), dto.getAmount());
        return ResponseEntity.ok(result);
    }
}

