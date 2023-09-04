package no.fintlabs.otstatus;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.kodeverk.OtStatusResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OTStatusService {

    private final OTStatusJpaRepository otStatusJpaRepository;

    public OTStatusService(OTStatusJpaRepository otStatusJpaRepository) {
        this.otStatusJpaRepository = otStatusJpaRepository;

    }

    public List<OtStatusResource> getResources() {
        List<OTStatusEntity> otStatusEntities = otStatusJpaRepository.findByAktiv("J");

        return otStatusEntities.stream()
                .map(this::createResource)
                .collect(Collectors.toList());
    }

    private OtStatusResource createResource(OTStatusEntity otStatusEntity) {
        OtStatusResource otStatusResource = new OtStatusResource();

        otStatusResource.setBeskrivelse(otStatusEntity.getBeskriv());
        otStatusResource.setType(otStatusEntity.getType());
        otStatusResource.setNavn(otStatusEntity.getNavn());
        otStatusResource.setKode(otStatusEntity.getOtStatus());

        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(otStatusEntity.getOtStatus());
        otStatusResource.setSystemId(identifikator);

        otStatusResource.addSelf(Link.with(OtStatusResource.class, "systemid", otStatusEntity.getOtStatus()));

        return otStatusResource;
    }

}
