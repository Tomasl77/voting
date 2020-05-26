package fr.formation.voting.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "poll_station")
public class PollStation extends AbstractEntity {

    @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Adress adress;

    @Column(name = "cote_office_number", nullable = false)
    private int voteOfficeNumber;

    public PollStation() {
    }
}
