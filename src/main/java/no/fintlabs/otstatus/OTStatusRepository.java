package no.fintlabs.otstatus;

import no.fint.model.resource.utdanning.kodeverk.OTStatusResource;
import no.fintlabs.adapter.events.WriteableResourceRepository;
import no.fintlabs.adapter.models.RequestFintEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OTStatusRepository implements WriteableResourceRepository<OTStatusResource> {

    private final OTStatusService otStatusService;

    public OTStatusRepository(OTStatusService otStatusService) {
        this.otStatusService = otStatusService;
    }

    @Override
    public OTStatusResource saveResources(OTStatusResource resource, RequestFintEvent requestFintEvent) {
        return null;
    }

    @Override
    public List<OTStatusResource> getResources() {
        return otStatusService.getResources();
    }

    @Override
    public List<OTStatusResource> getUpdatedResources() {
        return new ArrayList<>();
    }
}