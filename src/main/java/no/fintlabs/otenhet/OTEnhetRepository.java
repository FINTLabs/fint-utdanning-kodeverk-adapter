package no.fintlabs.otenhet;

import no.fint.model.resource.utdanning.kodeverk.OtEnhetResource;
import no.fintlabs.adapter.events.WriteableResourceRepository;
import no.fintlabs.adapter.models.RequestFintEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OTEnhetRepository implements WriteableResourceRepository<OtEnhetResource> {

    private final OTEnhetService otEnhetService;

    public OTEnhetRepository(OTEnhetService otEnhetService) {
        this.otEnhetService = otEnhetService;
    }

    @Override
    public OtEnhetResource saveResources(OtEnhetResource resource, RequestFintEvent requestFintEvent) {
        return null;
    }

    @Override
    public List<OtEnhetResource> getResources() {
        return otEnhetService.getResources();
    }

    @Override
    public List<OtEnhetResource> getUpdatedResources() {
        return new ArrayList<>();
    }
}