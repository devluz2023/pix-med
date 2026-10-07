// adapter/out/db/SpringDataMedRepository.java
package br.com.faluz.pix_med.adapter.out.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMedRepository extends JpaRepository<MedJpaEntity, String> {
}