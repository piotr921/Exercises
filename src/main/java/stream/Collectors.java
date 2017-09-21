package stream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Collectors {

    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "ad", "dd", "db", "cdc");

//        List<String> result = givenList.stream()
//            .collect(toList());

//        Set<String> result = givenList.stream()
//            .collect(toSet());

//        Set<String> result = givenList.stream()
//            .collect(toCollection(ConcurrentSkipListSet::new));

        // returns map <String, Sum of letters in all this string occurrences>
//        Map<String, Integer> result = givenList.stream()
//            .collect(toMap(Function.identity(), String::length, (value1, value2) -> value1 + value2));

        // returns map <Length of string, all strings with this length as one string divided with ','>
//        Map<Integer, String> result = givenList.stream()
//            .collect(toMap(String::length, Function.identity(), (s1, s2) -> s1 + ", " + s2));

        // returns map <Length of string, all strings with this length as list>
//        Map<Integer, List<String>> result = givenList.stream()
//            .collect(groupingBy(String::length));

//       List<String> result = givenList.stream()
//            .collect(collectingAndThen(toList(), stream.Collectors::finishThem));

//        String result = givenList.stream()
//            .collect(joining(";", "Prefix: ", " >Suffix"));

//        Long result = givenList.stream()
//            .collect(counting());

//        DoubleSummaryStatistics result = givenList.stream()
//            .collect(summarizingDouble(String::length));

//        Double result = givenList.stream()
//            .collect(averagingInt(String::length));
        // also summing

//        Optional<String> result = givenList.stream()
//            .collect(maxBy(Comparator.comparing(String::length)));

//        Map<Integer, Set<String>> result = givenList.stream()
//            .collect(groupingBy(String::length, toSet()));

//        Map<Boolean, List<String>> result = givenList.stream()
//            .collect(partitioningBy(text -> text.contains("d")));

        ImmutableSet<String> result = givenList.stream()
            .collect(ImmutableSetCollector.toImmutableSet());

        display(result);
    }

    private static void display(DoubleSummaryStatistics result) {
        System.out.println(result.getAverage());
        System.out.println(result.getCount());
        System.out.println(result.getSum());
        System.out.println(result.getMax());
        System.out.println(result.getMin());
    }

    private static <T> void display(Collection<T> result) {
        System.out.println(result.getClass());
        result.forEach(System.out::println);
    }

    private static <T, S> void display(Map<T, S> result) {
        System.out.println(result.getClass());
        result.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static <T> void display(T result) {
        System.out.println(result);
    }

    private static List<String> finishThem(List<String> input) {
        return input.stream()
            .map(value -> value + "!")
            .collect(toList());
    }
}
