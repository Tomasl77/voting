package fr.formation.voting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "towns")
public class Town extends AbstractEntity {

    @Column(name = "zip_code", nullable = false, length = 5, columnDefinition = "INT UNSIGNED")
    private int zipCode;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    public Town() {
    }
}
