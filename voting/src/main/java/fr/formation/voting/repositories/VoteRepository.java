package fr.formation.voting.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.voting.entities.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Derived queries:
    // 1. find Votes by polling station identifier at a specific polling date
    // order by voting time asc
    // SQL: select * from votes WHERE DATE(vote_hour) = "2017-04-27" ORDER BY
    // poll_id;
    // Derived query:
    List<Vote> findByVoteHourOrderByPollId(LocalDateTime voteHour);
}
