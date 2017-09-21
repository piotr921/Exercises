package stream;

/**
 * @author Piotr_Sekula
 * @since 19.09.2017.
 */
public class Tuple {
    BlogPostType type;
    String author;

    public Tuple(BlogPostType type, String author) {
        this.type = type;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tuple tuple = (Tuple) o;

        if (type != tuple.type) {
            return false;
        }
        return author.equals(tuple.author);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
               "type=" + type +
               ", author='" + author + '\'' +
               '}';
    }
}
