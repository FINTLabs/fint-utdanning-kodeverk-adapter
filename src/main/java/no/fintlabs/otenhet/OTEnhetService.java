package no.fintlabs.otenhet;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.kodeverk.OtEnhetResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OTEnhetService {

    private final OTEnhetJpaRepository otEnhetJpaRepository;

    @Value("${fint.fylkesnr}")
    private int fylkesnr;

    public OTEnhetService(OTEnhetJpaRepository otEnhetJpaRepository) {
        this.otEnhetJpaRepository = otEnhetJpaRepository;
    }

    public List<OtEnhetResource> getResources() {
        List<OTEnhetEntity> otEnhetEntities = otEnhetJpaRepository.findByAktiv("J");

        return otEnhetEntities.stream()
                .filter(otEnhetEntity -> otEnhetEntity.getFylkesnr() == fylkesnr)
                .map(this::createResource)
                .collect(Collectors.toList());
    }

    private OtEnhetResource createResource(OTEnhetEntity otEnhetEntity) {
        OtEnhetResource otEnhetResource = new OtEnhetResource();
        otEnhetResource.setKode(otEnhetEntity.getOtStatus());
        otEnhetResource.setNavn(otEnhetEntity.getNavn());

        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(otEnhetEntity.getOtStatus());
        otEnhetResource.setSystemId(identifikator);

        otEnhetResource.addSelf(Link.with(OtEnhetResource.class, "systemid", otEnhetEntity.getOtStatus()));

        return otEnhetResource;
    }

}
