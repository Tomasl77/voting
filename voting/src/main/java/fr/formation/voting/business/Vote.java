package fr.formation.voting.business;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
@Table(name = "votes", uniqueConstraints = {
        @UniqueConstraint(name = "UK_unique_vote_per_roll", columnNames = {
                "elector_id", "poll_id" }),
        @UniqueConstraint(name = "UK_vote_hour", columnNames = {
                "vote_hour" }) }, indexes = {
                        @Index(name = "IDX_vote_poll_id", columnList = "poll_id"),
                        @Index(name = "IDX_vote_elector_id", columnList = "elector_id"),
                        @Index(name = "IDX_vote_candidate_id", columnList = "candidate_id") })
public class Vote extends AbstractEntity {

    @JoinColumn(name = "poll_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_poll_id"))
    @ManyToOne
    private Poll poll;

    @JoinColumn(name = "elector_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_elector_id"))
    @ManyToOne
    private Elector elector;

    @JoinColumn(name = "candidate_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vote_candidate_id"))
    @ManyToOne
    private Candidate candidate;

    @Column(name = "vote_hour", nullable = false)
    private LocalDateTime voteHour;

    protected Vote() {
    }
}
