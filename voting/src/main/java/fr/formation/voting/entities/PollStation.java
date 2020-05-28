package fr.formation.voting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "poll_stations", indexes = {
        @Index(name = "IDX_poll_station_adress_id", columnList = "adress_id") })
public class PollStation extends AbstractEntity {

    @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_poll_stations_adress_id"))
    @OneToOne
    private Adress adress;

    @Column(name = "vote_office_number", nullable = false, columnDefinition = "INT UNSIGNED")
    private int voteOfficeNumber;

    public PollStation() {
    }
}
