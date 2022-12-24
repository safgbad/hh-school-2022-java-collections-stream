package tasks;

import common.Area;
import common.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Имеются
- коллекция персон Collection<Person>
- словарь Map<Integer, Set<Integer>>, сопоставляющий каждой персоне множество id регионов
- коллекция всех регионов Collection<Area>
На выходе хочется получить множество строк вида "Имя - регион". Если у персон регионов несколько, таких строк так же будет несколько
 */
public class Task6 {

  public static Set<String> getPersonDescriptions(Collection<Person> persons,
                                                  Map<Integer, Set<Integer>> personAreaIds,
                                                  Collection<Area> areas) {
      Map<Integer, Area> areasMap = areas.stream().collect(Collectors.toMap(Area::getId, area -> area));
      return persons.stream()
              .flatMap(person -> getStringsForOnePerson(personAreaIds, areasMap, person))
              .collect(Collectors.toSet());
  }

  public static Stream<String> getStringsForOnePerson(Map<Integer, Set<Integer>> personAreaIds,
                                                      Map<Integer, Area> areasMap,
                                                      Person person) {
      return personAreaIds.get(person.getId()).stream()
              .map(areaId -> person.getFirstName() + " - " + areasMap.get(areaId).getName());
  }
}
