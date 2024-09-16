import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

public class Student {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("홍길동", 28, "서울"),
                new Person("이순신", 32, "부산"),
                new Person("김유신", 24, "서울"),
                new Person("세종대왕", 30, "대전"),
                new Person("이방원", 35, "부산")
        );

        // 1. Filtering: 나이가 30 이상인 사람들
        // 조건에 맞는 데이터들을 걸러냅니다.
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() >= 30)
                .collect(Collectors.toList());
        System.out.println("나이가 30 이상인 사람들:");
        filteredPeople.forEach(System.out::println);

        // 2. Mapping: 모든 사람들의 이름을 리스트로 추출
        // 원하는 자료구조로 변환합니다.
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("\n모든 사람들의 이름:");
        names.forEach(System.out::println);

        // 3. Sorting: 나이순으로 정렬
        // 순서가 있는 자료구조에서 순서를 정렬합니다.
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("\n나이순으로 정렬:");
        sortedByAge.forEach(System.out::println);

        // 4. Aggregating: 모든 사람의 나이 합계
        // 데이터를 모아 연산을 수행합니다.
        int totalAge = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("\n모든 사람의 나이 합계: " + totalAge);

        // max - 나이 많은 사람 찾기
        Optional<Person> oldestPerson = people.stream()
                .max(Comparator.comparingInt(Person::getAge));
        oldestPerson.ifPresent(person -> System.out.println("\n가장 나이가 많은 사람: " + person));

        // min - 나이 적은 사람 찾기
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparingInt(Person::getAge));
        youngestPerson.ifPresent(person -> System.out.println("\n가장 나이가 적은 사람: " + person));

        // 5. Grouping: 도시에 따른 그룹화
        // 특정 데이터 필드를 바탕으로 그룹화를 수행합니다.
        System.out.println("\n도시에 따른 그룹화:");
        Map<String, List<Person>> groupedByCity = people.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        groupedByCity.forEach((city, persons) -> {
            System.out.println(city + ": " + persons);
        });
    }
}