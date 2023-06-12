package no.fintlabs.otenhet;

import no.fint.model.resource.utdanning.kodeverk.OTEnhetResource;
import no.fintlabs.adapter.events.WriteableResourceRepository;
import no.fintlabs.adapter.models.RequestFintEvent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OTEnhetRepository implements WriteableResourceRepository<OTEnhetResource> {


    public OTEnhetRepository() {

    }

    @Override
    public OTEnhetResource saveResources(OTEnhetResource resource, RequestFintEvent requestFintEvent) {
        return null;
    }

    @Override
    public List<OTEnhetResource> getResources() {
        return null;
    }

    @Override
    public List<OTEnhetResource> getUpdatedResources() {
        return new ArrayList<>();
    }
}