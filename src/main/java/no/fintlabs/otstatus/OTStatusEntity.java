package no.fintlabs.otstatus;

import lombok.Data;

@Data
@Entity
@Table(name = "OTStatus")
public class OTStatus {

    @Id
    @Column(name = "ot_status")
    private String otStatus;

    @Column(name = "aktiv")
    private char aktiv;

    @Column(name = "beskriv")
    private String beskriv;

    @Column(name = "navn")
    private String navn;
}