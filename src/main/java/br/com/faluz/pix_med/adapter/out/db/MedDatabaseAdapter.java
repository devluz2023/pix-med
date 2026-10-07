package br.com.faluz.pix_med.adapter.out.db;

import org.springframework.stereotype.Component;

import br.com.faluz.pix_med.domain.entity.MedRequest;
import br.com.faluz.pix_med.domain.port.out.MedRequestRepository;

@Component
public class MedDatabaseAdapter implements MedRequestRepository {

    private final SpringDataMedRepository springRepository;

    public MedDatabaseAdapter(SpringDataMedRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public MedRequest save(MedRequest domainRequest) {
        // 1. Converte Domínio -> JPA usando os dados reais do domínio
        MedJpaEntity entity = new MedJpaEntity(
            domainRequest.getId(), 
            domainRequest.getTransactionId(), 
            domainRequest.getAmount(), 
            domainRequest.getStatus()
        );
        
        // 2. Salva no MySQL
        MedJpaEntity saved = springRepository.save(entity);
        
        // 3. Converte JPA -> Domínio usando o construtor completo (preservando ID e status)
        return new MedRequest(
            saved.getId(),
            saved.getTransactionId(),
            saved.getAmount(),
            saved.getStatus()
        );
    }
}