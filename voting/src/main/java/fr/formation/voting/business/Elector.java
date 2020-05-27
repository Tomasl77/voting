package fr.formation.voting.business;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "electors", indexes = {
        @Index(name = "IDX_electors_person_id", columnList = "person_id"),
        @Index(name = "IDX_electros_living_place_id", columnList = "living_place_id"),
        @Index(name = "IDX_electors_place_of_birth_id", columnList = "place_of_birth_id"),
        @Index(name = "IDX_electors_poll_station_id", columnList = "poll_station_id") })
public class Elector extends AbstractEntity {

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "oreder_on_list", nullable = false, columnDefinition = "INT UNSIGNED")
    private int orderOnList;

    @Column(name = "elector_national_number", nullable = false, unique = true, columnDefinition = "INT UNSIGNED")
    private int electorNationalNumber;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_electors_person_id"), columnDefinition = "INT UNSIGNED")
    @OneToOne
    private Person person;

    @JoinColumn(name = "living_place_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_electors_livaing_place_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private Adress adress;

    @JoinColumn(name = "place_of_birth_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_electors_place_of_birth_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private Town town;

    @JoinColumn(name = "poll_station_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_electors_poll_station_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private PollStation pollStation;

    public Elector() {
    }
}
