package no.fintlabs.otenhet;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "OTEnhet")
public class OTEnhetEntity {

    @Id
    @Column(name = "otenhet")
    private String otStatus;

    @Column(name = "aktiv")
    private String aktiv;

    @Column(name = "fylkesnr")
    private int fylkesnr;

    @Column(name = "navn")
    private String navn;

}