package no.fintlabs.otenhet;

import no.fint.model.resource.utdanning.kodeverk.OTEnhetResource;
import no.fintlabs.adapter.config.AdapterProperties;
import no.fintlabs.adapter.datasync.ResourceSubscriber;
import no.fintlabs.adapter.models.AdapterCapability;
import no.fintlabs.adapter.models.SyncPageEntry;
import no.fintlabs.adapter.validator.ValidatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OTEnhetSubscriber extends ResourceSubscriber<OTEnhetResource, OTEnhetPublisher> {

    protected OTEnhetSubscriber(WebClient webClient, AdapterProperties props, OTEnhetPublisher publisher, ValidatorService<OTEnhetResource> validatorService) {
        super(webClient, props, publisher, validatorService);
    }

    @Override
    protected AdapterCapability getCapability() {
        return adapterProperties.getCapabilities().get("otenhet");
    }

    @Override
    protected SyncPageEntry<OTEnhetResource> createSyncPageEntry(OTEnhetResource resource) {
        return SyncPageEntry.of(resource.getSystemId().getIdentifikatorverdi(), resource);
    }
}
