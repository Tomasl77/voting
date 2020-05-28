package fr.formation.voting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
public class Person extends AbstractEntity {

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "birthname", nullable = true, length = 45)
    private String birthname;

    public Person() {
    }
}
