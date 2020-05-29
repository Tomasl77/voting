package fr.formation.voting.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Elector;

@Repository
public interface ElectorRepository extends JpaRepository<Elector, Long> {
    // 1. find Elector by national identifier
    // SQL: select * from electors ORDER BY elector_national_number ASC;

    List<Elector> findByOrderByElectorNationalNumber();

    // 2. find Electors by birthdate between two dates order by lastname asc
    // SQL: select * from electors WHERE (birthdate BETWEEN '1980-01-01' AND
    // '1990-01-01') ;
    List<Elector> findByBirthdateBetween(LocalDate date1, LocalDate date2);
    // 3. find Electors by birthdate before a date and birth town not a specific
    // zip code order by lastname desc
    // SQL: SELECT * FROM electors e INNER JOIN persons p ON e.person_id = p.id
    // INNER JOIN towns t ON e.place_of_birth_id = t.id WHERE (t.zip_code <>
    // 77260 AND e.birthdate < '1970-01-01')
    // ORDER BY p.lastname DESC

    List<Elector> findByTownZipCodeNotAndBirthdateLessThan(int zipCode,
            LocalDate birthdate);
}
