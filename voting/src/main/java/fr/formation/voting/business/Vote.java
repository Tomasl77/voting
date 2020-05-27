package fr.formation.voting.business;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes", indexes = {
        @Index(name = "unique_vote_per_roll", columnList = "elector_id, poll_id") })
public class Vote extends AbstractEntity {

    @JoinColumn(name = "poll_id", nullable = false)
    @ManyToOne
    private Poll poll;

    @JoinColumn(name = "elector_id", nullable = false)
    @ManyToOne
    private Elector elector;

    @JoinColumn(name = "candidate_id", nullable = false)
    @ManyToOne
    private Candidate candidate;

    protected Vote() {
    }
}
