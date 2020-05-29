package fr.formation.voting.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.voting.entities.Adress;
import fr.formation.voting.entities.Elector;
import fr.formation.voting.entities.Person;
import fr.formation.voting.entities.QueryResult;
import fr.formation.voting.entities.Vote;
import fr.formation.voting.repositories.AdressRepository;
import fr.formation.voting.repositories.CandidateRepository;
import fr.formation.voting.repositories.ElectorRepository;
import fr.formation.voting.repositories.PersonRepository;
import fr.formation.voting.repositories.PollRepository;
import fr.formation.voting.repositories.TownReposiroty;
import fr.formation.voting.repositories.VoteRepository;
import fr.formation.voting.services.GlobalService;

@Service
public class GlobalServiceImpl implements GlobalService {

    @Autowired
    private AdressRepository adressRepo;

    @Autowired
    private CandidateRepository candidateRepo;

    @Autowired
    private ElectorRepository electorRepo;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private PollRepository pollRepo;

    @Autowired
    private PollRepository pollSationRepo;

    @Autowired
    private TownReposiroty townRepo;

    @Autowired
    private VoteRepository voteRepo;

    @Override
    public QueryResult adress() {
	int zipCode = 77260;
	List<Adress> result = adressRepo
	        .findByTownZipCodeOrderByStreetAsc(zipCode);
	return new QueryResult(result);
    }

    @Override
    public QueryResult vote() {
	String voteHour = "2017-04-27 16:19:43";
	DateTimeFormatter formatter = DateTimeFormatter
	        .ofPattern("yyyy-MM-dd HH:mm:ss");
	LocalDateTime dateTime = LocalDateTime.parse(voteHour, formatter);
	List<Vote> result = voteRepo.findByVoteHourOrderByPollId(dateTime);
	return new QueryResult(result);
    }

    @Override
    public QueryResult person() {
	String finishedBy = "is";
	List<Person> result = personRepo
	        .findByLastnameEndingWithOrderByFirstnameDesc(finishedBy);
	return new QueryResult(result);
    }

    @Override
    public QueryResult electorOrderByNationalNumber() {
	List<Elector> result = electorRepo.findByOrderByElectorNationalNumber();
	return new QueryResult(result);
    }

    @Override
    public QueryResult electorBetweenTwoBirthDate() {
	DateTimeFormatter dateFormatter = DateTimeFormatter
	        .ofPattern("yyyy-MM-dd");
	LocalDate date1 = LocalDate.parse("1970-01-01", dateFormatter);
	LocalDate date2 = LocalDate.parse("1980-01-01", dateFormatter);
	List<Elector> result = electorRepo.findByBirthdateBetween(date1, date2);
	return new QueryResult(result);
    }

    @Override
    public QueryResult electorNotInTownAndBornBefore() {
	int zipCode = 77260;
	DateTimeFormatter dateFormatter = DateTimeFormatter
	        .ofPattern("yyyy-MM-dd");
	LocalDate birthdate = LocalDate.parse("1985-01-01", dateFormatter);
	List<Elector> result = electorRepo
	        .findByTownZipCodeNotAndBirthdateLessThan(zipCode, birthdate);
	return new QueryResult(result);
    }
}
