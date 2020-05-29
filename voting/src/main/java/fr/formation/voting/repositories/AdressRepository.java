package fr.formation.voting.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    // SQL: select * from addresses a inner join towns t on a.town_id = t.id

    List<Adress> findByTownZipCodeOrderByStreetAsc(int zipCode);
}
