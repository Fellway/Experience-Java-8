package academy.elqoo.java8.stream;


import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.sun.xml.internal.ws.util.StringUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        return numbers.stream().map(a -> (int) Math.sqrt(a)).collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user) {
        return user.stream().map(a -> a.getAge()).collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        return users.stream().map(a -> a.getAge()).distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        return (int) users.stream().filter(a -> a.getAge() > 25).count();
    }

    public static List<String> mapToUpperCase(List<String> strings) {
        return strings.stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers) {
        return integers.stream().mapToInt(a -> a.intValue()).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        return names.stream().map(a -> a.split(" ")[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names) {
        return names.stream().flatMap(a -> Arrays.stream(a.split(""))).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users) {
        return users.stream().map(a -> a.getName()).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users) {
        return users.stream().mapToInt(a -> a.getAge()).average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users) {
        return users.stream().mapToInt(a -> a.getAge()).max().getAsInt();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).min().getAsInt();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(a -> a.isMale(), Collectors.toList()));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(a -> a.getAge(), Collectors.toList()));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(a -> a.isMale(), Collectors.groupingBy(a -> a.getAge(), Collectors.toList())));
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::isMale, Collectors.counting()));
    }

    public static boolean anyMatch(List<User> users, int age) {
        return users.stream().anyMatch(a -> a.getAge().equals(age));
    }

    public static boolean noneMatch(List<User> users, int age) {
        return users.stream().noneMatch(a -> a.getAge().equals(age));
    }

    public static Optional<User> findAny(List<User> users, String name) {
        return users.stream().findAny();
    }

    public static List<User> sortByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return stream.boxed();
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        return Stream.iterate(2, i -> i + 1)
                .filter(x -> isPrime(x))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers() {
       return new Random().ints(10).boxed().collect(Collectors.toList());
    }

    public static User findOldest(List<User> users) {
        return users.stream().sorted((a, b) -> b.getAge().compareTo(a.getAge())).findFirst().get();
    }

    public static int sumAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return users.stream().mapToInt(User::getAge).summaryStatistics();
    }
}
