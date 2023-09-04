package no.fintlabs.otstatus;

import no.fint.model.resource.utdanning.kodeverk.OtStatusResource;
import no.fintlabs.adapter.config.AdapterProperties;
import no.fintlabs.adapter.datasync.ResourceSubscriber;
import no.fintlabs.adapter.models.AdapterCapability;
import no.fintlabs.adapter.models.SyncPageEntry;
import no.fintlabs.adapter.validator.ValidatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OTStatusSubscriber extends ResourceSubscriber<OtStatusResource, OTStatusPublisher> {

    protected OTStatusSubscriber(WebClient webClient, AdapterProperties props, OTStatusPublisher publisher, ValidatorService<OtStatusResource> validatorService) {
        super(webClient, props, publisher, validatorService);
    }

    @Override
    protected AdapterCapability getCapability() {
        return adapterProperties.getCapabilities().get("otstatus");
    }

    @Override
    protected SyncPageEntry<OtStatusResource> createSyncPageEntry(OtStatusResource resource) {
        return SyncPageEntry.of(resource.getSystemId().getIdentifikatorverdi(), resource);
    }
}
