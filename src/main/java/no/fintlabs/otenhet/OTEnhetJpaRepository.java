package no.fintlabs.otenhet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTEnhetJpaRepository extends JpaRepository<OTEnhetEntity, String> {
}
