package no.fintlabs.otstatus;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.utdanning.kodeverk.OtStatusResource;
import no.fintlabs.adapter.config.AdapterProperties;
import no.fintlabs.adapter.datasync.ResourcePublisher;
import no.fintlabs.adapter.datasync.ResourceRepository;
import no.fintlabs.adapter.datasync.SyncData;
import no.fintlabs.adapter.models.AdapterCapability;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OTStatusPublisher extends ResourcePublisher<OtStatusResource, ResourceRepository<OtStatusResource>> {

    public OTStatusPublisher(OTStatusRepository repository, AdapterProperties adapterProperties) {
        super(repository, adapterProperties);
    }

    @Override
    @Scheduled(initialDelayString = "1000", fixedRateString = "500000")
    public void doFullSync() {
        log.info("Start full sync for resource {}", getCapability().getEntityUri());
        submit(SyncData.ofPostData(repository.getResources()));
    }

    // Not in use
    @Override
    public void doDeltaSync() {
        submit(SyncData.ofPatchData(repository.getUpdatedResources()));
    }

    @Override
    protected AdapterCapability getCapability() {
        return adapterProperties.getCapabilityByResource("otstatus");
    }
}
