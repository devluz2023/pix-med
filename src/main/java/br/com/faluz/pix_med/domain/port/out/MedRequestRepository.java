package br.com.faluz.pix_med.domain.port.out;

import br.com.faluz.pix_med.domain.entity.MedRequest;

public interface MedRequestRepository {
    MedRequest save(MedRequest request);
}