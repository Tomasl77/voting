package fr.formation.voting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
