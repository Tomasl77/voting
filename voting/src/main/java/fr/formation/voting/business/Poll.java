package fr.formation.voting.business;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "polls")
public class Poll extends AbstractEntity {

    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;

    @Column(name = "round", nullable = false)
    private int round;

    @Column(name = "year_of_election", nullable = false)
    private int yearOfElection;

    public Poll() {
    }
}
