package fr.formation.voting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
