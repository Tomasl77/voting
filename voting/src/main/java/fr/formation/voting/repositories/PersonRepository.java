package fr.formation.voting.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Derived queries:
    // 1. find Persons by lastname ending with a string order by firstnames desc
    // SQL: select * from persons WHERE lastname LIKE '%S' ORDER BY firstname
    // DESC;
    // Derived query:

    List<Person> findByLastnameEndingWithOrderByFirstnameDesc(String lastname);
}
