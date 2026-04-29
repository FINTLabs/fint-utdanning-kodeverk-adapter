package no.fintlabs.otstatus;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "OTStatus", schema = "VIGOS")
public class OTStatusEntity {

    @Id
    @Column(name = "otstatus")
    private String otStatus;

    @Column(name = "aktiv")
    private String aktiv;

    @Column(name = "beskriv")
    private String beskriv;

    @Column(name = "navn")
    private String navn;

    @Column(name = "type")
    private String type;
}