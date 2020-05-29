package fr.formation.voting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.voting.entities.QueryResult;
import fr.formation.voting.services.GlobalService;

@RestController
@RequestMapping("/election")
public class MainController {

    @Autowired
    private GlobalService service;

    @GetMapping("/adress")
    public QueryResult adress() {
	return service.adress();
    }

    @GetMapping("/vote")
    public QueryResult vote() {
	return service.vote();
    }

    @GetMapping("/person")
    public QueryResult person() {
	return service.person();
    }

    @GetMapping("/electorByNumber")
    public QueryResult electorByNumber() {
	return service.electorOrderByNationalNumber();
    }

    @GetMapping("/electorBetweenBirthDate")
    public QueryResult electorBetweenBirthDate() {
	return service.electorBetweenTwoBirthDate();
    }

    @GetMapping("/electorNotInTownAndBornBefore")
    public QueryResult electorNotInTownAndBornBefore() {
	return service.electorNotInTownAndBornBefore();
    }
}
