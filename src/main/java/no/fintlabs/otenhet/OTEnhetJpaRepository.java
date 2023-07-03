package no.fintlabs.otenhet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTEnhetJpaRepository extends JpaRepository<OTEnhetEntity, String> {

    List<OTEnhetEntity> findByAktiv(String aktiv);

}
