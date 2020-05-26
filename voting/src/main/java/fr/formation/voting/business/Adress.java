package fr.formation.voting.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "adresses")
public class Adress extends AbstractEntity {

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private int number;

    // @JoinColumn(name = "town_id", referencedColumnName = "id")
    // nom de la colonne dans la base, nom de la colonne qu'on veut referencer
    @JoinColumn(name = "town_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Town town;

    public Adress() {
    }
}
