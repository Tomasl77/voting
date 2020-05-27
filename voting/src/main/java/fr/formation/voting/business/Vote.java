package fr.formation.voting.business;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes", uniqueConstraints = @UniqueConstraint(name = "UK_unique_vote_per_roll", columnNames = {
        "elector_id", "poll_id" }), indexes = {
                @Index(name = "IDX_vote__poll_id", columnList = "poll_id"),
                @Index(name = "IDX_vote_elector_id", columnList = "elector_id"),
                @Index(name = "IDX_vote_candidate_id", columnList = "candidate_id") })
public class Vote extends AbstractEntity {

    @JoinColumn(name = "poll_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_poll_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private Poll poll;

    @JoinColumn(name = "elector_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_elector_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private Elector elector;

    @JoinColumn(name = "candidate_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_candidate_id"), columnDefinition = "INT UNSIGNED")
    @ManyToOne
    private Candidate candidate;

    protected Vote() {
    }
}
