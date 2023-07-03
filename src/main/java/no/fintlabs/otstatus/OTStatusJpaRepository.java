package no.fintlabs.otstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OTStatusJpaRepository extends JpaRepository<OTStatusEntity, String> {

    List<OTStatusEntity> findByAktiv(String aktiv);

}
