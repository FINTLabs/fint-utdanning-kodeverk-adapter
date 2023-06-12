package no.fintlabs.otstatus;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.kodeverk.OTStatusResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OTStatusService {

    private final OTStatusJpaRepository otStatusJpaRepository;

    public OTStatusService(OTStatusJpaRepository otStatusJpaRepository) {
        this.otStatusJpaRepository = otStatusJpaRepository;
    }

    public List<OTStatusResource> getResources() {
        List<OTStatusEntity> otStatusEntities = otStatusJpaRepository.findAll();

        return otStatusEntities.stream()
                .filter(otStatusEntity -> otStatusEntity.getAktiv().equals("J"))
                .map(this::createResource)
                .collect(Collectors.toList());
    }

    private OTStatusResource createResource(OTStatusEntity otStatusEntity) {
        OTStatusResource otStatusResource = new OTStatusResource();

        otStatusResource.setBeskrivelse(otStatusEntity.getBeskriv());
        otStatusResource.setType(otStatusEntity.getType());
        otStatusResource.setNavn(otStatusEntity.getNavn());
        otStatusResource.setKode(otStatusEntity.getOtStatus());

        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(otStatusEntity.getOtStatus());
        otStatusResource.setSystemId(identifikator);

        otStatusResource.addSelf(Link.with(OTStatusResource.class, "systemid", otStatusEntity.getOtStatus()));

        return otStatusResource;
    }

}
