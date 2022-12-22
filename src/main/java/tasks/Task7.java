package tasks;

import common.Company;
import common.Vacancy;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Из коллекции компаний необходимо получить всевозможные различные названия вакансий
 */
public class Task7 {

  public static Set<String> vacancyNames(Collection<Company> companies) {
    return companies.stream()
            .flatMap(Task7::getVacancyTitlesForOneCompany)
            .collect(Collectors.toSet());
  }

  public static Stream<String> getVacancyTitlesForOneCompany(Company company) {
    return company.getVacancies().stream().map(Vacancy::getTitle);
  }
}
