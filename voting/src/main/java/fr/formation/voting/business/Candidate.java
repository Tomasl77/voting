package fr.formation.voting.business;

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
@Table(name = "candidates", indexes = {
        @Index(name = "IDX_candidates_person_id", columnList = "person_id") })
public class Candidate extends AbstractEntity {

    @Column(name = "political_party", nullable = false, length = 45)
    private String politicalParty;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_candidates_person_id"), columnDefinition = "INT UNSIGNED")
    @OneToOne
    private Person person;

    public Candidate() {
    }
}
