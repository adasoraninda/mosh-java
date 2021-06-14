package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(new Movie("a", 10, Genre.THRILLER), new Movie("b", 15, Genre.ACTION),
                new Movie("c", 20, Genre.ACTION));

        // Imperative Programming
        int count = 0;
        for (var movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }

        // Declarative (Functional) Programming
        var count2 = movies.stream().filter(movie -> movie.getLikes() > 10).count();

        // Array Stream
        int[] numbers = { 1, 2, 3 };
        Arrays.stream(numbers).forEach(n -> System.out.println(n));

        // Stream infinite
        var stream = Stream.generate(() -> Math.random());
        stream.limit(3).forEach(System.out::println);

        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

        // Stream map
        movies.stream().map(movie -> movie.getTitle()).forEach(System.out::println);
        // Flat map Stream<List<x>> -> Stream<x>
        var stream2 = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        stream2.flatMap(list -> list.stream()).forEach(System.out::println);

        // Stream filter
        Predicate<Movie> isPopular = m -> m.getLikes() > 10;
        movies.stream().filter(isPopular).forEach(System.out::println);

        // Stream Slicing
        movies.stream().limit(2).forEach(System.out::println);
        movies.stream().skip(2).forEach(System.out::println);
        movies.stream().takeWhile(m -> m.getLikes() < 30).forEach(System.out::println);
        movies.stream().dropWhile(m -> m.getLikes() < 30).forEach(System.out::println);

        // Pagination
        // 1000 movies
        // 10 movies per page (pageSize)
        // 3rd page (page)
        // skip(20) = skip((page-1) * pageSize)
        // limit(10) = limit(pageSize)

        // Stream sort
        movies.stream().sorted((a, b) -> a.getTitle().compareTo(b.getTitle())).forEach(System.out::println);
        movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).forEach(System.out::println);

        // Stream unique element
        movies.stream().map(Movie::getLikes).distinct().forEach(System.out::println);

        // Stream peek element
        movies.stream().filter(m -> m.getLikes() > 10).peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle).peek(t -> System.out.println("mapped: " + t)).forEach(System.out::println);

        // Stream reducers
        movies.stream().count();

        // Stream reducing
        // Accumulator
        // [10, 20, 30]
        // [30, 30]
        // [60]
        Optional<Integer> sum = movies.stream().map(Movie::getLikes).reduce(Integer::sum);
        System.out.println(sum.orElse(0));

        Integer sum2 = movies.stream().map(Movie::getLikes).reduce(0, Integer::sum);
        System.out.println(sum2);

        // Collector
        var resultList = movies.stream().filter(m -> m.getLikes() > 10).collect(Collectors.toList());
        var resultMap = movies.stream().filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        var resultTitles = movies.stream().map(Movie::getTitle).collect(Collectors.joining(", "));

        // Stream Grouping Element
        var resultGenre = movies.stream().collect(
                Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));

        // Stream Partitioning
        movies.stream().collect(Collectors.partitioningBy(m -> m.getLikes() > 20,
                Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));

    }
}
