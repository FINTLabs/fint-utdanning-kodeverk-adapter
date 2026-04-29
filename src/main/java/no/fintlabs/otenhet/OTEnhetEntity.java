package no.fintlabs.otenhet;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "OTENHET", schema = "VIGOS")
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