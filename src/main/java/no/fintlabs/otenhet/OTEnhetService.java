package no.fintlabs.otenhet;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.Link;
import no.fint.model.resource.utdanning.kodeverk.OTEnhetResource;
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

    public List<OTEnhetResource> getResources() {
        List<OTEnhetEntity> otEnhetEntities = otEnhetJpaRepository.findAll();

        return otEnhetEntities.stream()
                .filter(otEnhetEntity -> otEnhetEntity.getAktiv().equals("J") && otEnhetEntity.getFylkesnr() == fylkesnr)
                .map(this::createResource)
                .collect(Collectors.toList());
    }

    private OTEnhetResource createResource(OTEnhetEntity otEnhetEntity) {
        OTEnhetResource otEnhetResource = new OTEnhetResource();
        otEnhetResource.setKode(otEnhetEntity.getOtStatus());
        otEnhetResource.setNavn(otEnhetEntity.getNavn());

        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(otEnhetEntity.getOtStatus());
        otEnhetResource.setSystemId(identifikator);

        otEnhetResource.addSelf(Link.with(OTEnhetResource.class, "systemid", otEnhetEntity.getOtStatus()));

        return otEnhetResource;
    }

}
