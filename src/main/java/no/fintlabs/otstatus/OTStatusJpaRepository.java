package no.fintlabs.otstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTStatusJpaRepository extends JpaRepository<OTStatusEntity, String> {
}
