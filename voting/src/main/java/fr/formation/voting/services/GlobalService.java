package fr.formation.voting.services;

import fr.formation.voting.entities.QueryResult;

public interface GlobalService {

    QueryResult adress();

    QueryResult vote();

    QueryResult person();

    QueryResult electorOrderByNationalNumber();

    QueryResult electorBetweenTwoBirthDate();

    QueryResult electorNotInTownAndBornBefore();
}
