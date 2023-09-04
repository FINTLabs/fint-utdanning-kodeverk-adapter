package no.fintlabs.otenhet;

import no.fint.model.resource.utdanning.kodeverk.OtEnhetResource;
import no.fintlabs.adapter.config.AdapterProperties;
import no.fintlabs.adapter.datasync.ResourceSubscriber;
import no.fintlabs.adapter.models.AdapterCapability;
import no.fintlabs.adapter.models.SyncPageEntry;
import no.fintlabs.adapter.validator.ValidatorService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OTEnhetSubscriber extends ResourceSubscriber<OtEnhetResource, OTEnhetPublisher> {

    protected OTEnhetSubscriber(WebClient webClient, AdapterProperties props, OTEnhetPublisher publisher, ValidatorService<OtEnhetResource> validatorService) {
        super(webClient, props, publisher, validatorService);
    }

    @Override
    protected AdapterCapability getCapability() {
        return adapterProperties.getCapabilities().get("otenhet");
    }

    @Override
    protected SyncPageEntry<OtEnhetResource> createSyncPageEntry(OtEnhetResource resource) {
        return SyncPageEntry.of(resource.getSystemId().getIdentifikatorverdi(), resource);
    }
}
