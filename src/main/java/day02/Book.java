package day02;

public class Book {

    private Long id;
    private String writer;
    private String title;
    private long price;
    private long pieces;

    public Book(Long id, String writer, String title, long piece, long pieces) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.price = price;
        this.pieces = pieces;
    }

    public Long getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public long getPrice() {
        return price;
    }

    public long getPieces() {
        return pieces;
    }
}
