package no.fintlabs.otstatus;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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