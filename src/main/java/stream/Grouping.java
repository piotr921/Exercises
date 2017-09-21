package stream;

import static java.util.stream.Collectors.*;
import static stream.BlogPostType.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author Piotr_Sekula
 * @since 19.09.2017.
 */
public class Grouping {

    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList(
            new BlogPost("Tanie gotowanie", "Zenon", GUIDE, 230),
            new BlogPost("Fake news", "Adam", NEWS, 99),
            new BlogPost("Real news", "Anna", NEWS, 560),
            new BlogPost("Good old movies", "Ryszard", REVIEW, 370),
            new BlogPost("New series", "Ewelina", REVIEW, 155),
            new BlogPost("Italy for tourists", "Gian", GUIDE, 287),
            new BlogPost("News from Italy", "Gian", NEWS, 400),
            new BlogPost("News from Italy 2", "Gian", NEWS, 10)
        );

//        Map<BlogPostType, List<BlogPost>> result = posts.stream()
//            .collect(groupingBy(BlogPost::getType));

//        Map<Tuple, List<BlogPost>> result = posts.stream()
//            .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

//        Map<String, Set<BlogPost>> result = posts.stream()
//            .collect(groupingBy(BlogPost::getAuthor, toSet()));

//        Map<BlogPostType, Map<String, List<BlogPost>>> result = posts.stream()
//            .collect(groupingBy(BlogPost::getType, groupingBy(BlogPost::getAuthor)));

//        Map<String, Double> result = posts.stream()
////            .collect(groupingBy(BlogPost::getAuthor, averagingInt(blog -> blog.getTitle().length())));
//            .collect(groupingBy(BlogPost::getAuthor, averagingInt(BlogPost::getLikes)));

//        Map<String, Integer> result = posts.stream()
//            .collect(groupingBy(BlogPost::getAuthor, summingInt(BlogPost::getLikes)));

//        Map<BlogPostType, Optional<BlogPost>> result = posts.stream()
////            .collect(groupingBy(BlogPost::getType, maxBy(Comparator.comparing(BlogPost::getLikes))));
//            .collect(groupingBy(BlogPost::getType, minBy(Comparator.comparing(blog -> blog.getTitle().length()))));

//        Map<String, IntSummaryStatistics> result = posts.stream()
//            .collect(groupingBy(BlogPost::getAuthor, summarizingInt(BlogPost::getLikes)));

//        Map<String, String> result = posts.stream()
//            .collect(groupingBy(BlogPost::getAuthor,
//                                mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]"))));

        Map<BlogPost, List<String>> result = posts.stream()
            .collect(groupingBy(BlogPost::getType,
                                () -> new EnumMap(BlogPostType.class),
                                toList()));

        display(result);
    }

    private static <T, S> void display(Map<T, S> input) {
        System.out.println(input.getClass());
        input.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
