package no.fintlabs.otstatus;

import no.fint.model.resource.utdanning.kodeverk.OtStatusResource;
import no.fintlabs.adapter.events.WriteableResourceRepository;
import no.fintlabs.adapter.models.RequestFintEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OTStatusRepository implements WriteableResourceRepository<OtStatusResource> {

    private final OTStatusService otStatusService;

    public OTStatusRepository(OTStatusService otStatusService) {
        this.otStatusService = otStatusService;
    }

    @Override
    public OtStatusResource saveResources(OtStatusResource resource, RequestFintEvent requestFintEvent) {
        return null;
    }

    @Override
    public List<OtStatusResource> getResources() {
        return otStatusService.getResources();
    }

    @Override
    public List<OtStatusResource> getUpdatedResources() {
        return new ArrayList<>();
    }
}