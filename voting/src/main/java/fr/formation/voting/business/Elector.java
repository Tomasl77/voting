package fr.formation.voting.business;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "electors")
public class Elector extends AbstractEntity {

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "oreder_on_list", nullable = false)
    private int orderOnList;

    @Column(name = "elector_national_number", nullable = false)
    private int electorNationalNumber;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Person person;

    @JoinColumn(name = "living_place_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Adress adress;

    @JoinColumn(name = "place_of_birth_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Town town;

    @JoinColumn(name = "poll_station_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private PollStation pollStation;

    public Elector() {
    }
}
