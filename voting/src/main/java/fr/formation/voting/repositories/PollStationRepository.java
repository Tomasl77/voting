package fr.formation.voting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.PollStation;

@Repository
public interface PollStationRepository
        extends JpaRepository<PollStation, Long> {
}
