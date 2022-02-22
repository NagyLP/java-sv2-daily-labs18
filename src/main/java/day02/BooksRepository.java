package day02;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BooksRepository {

    private JdbcTemplate jdbcTemplate;

    public BooksRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
    }

    public void insertBook(String writer, String title, int price, int pieces) {
        jdbcTemplate.update("INSERT INTO books(writer,title,price,pieces)" +
                " VALUE(?,?,?,?)");
    }

    public List<Book> findBooksByWriter(String prefix) {
        return jdbcTemplate.query("SELECT * FROM books WHERE writer LIKE ?",
                this::createBook, prefix + "%");
    }

    private Book createBook(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getLong("id"),
                rs.getString("writer"),
                rs.getString("title"),
                rs.getInt("price"),
                rs.getInt("pieces")
        );
    }

    public void updatePieces(Long id, int pieces) {
        jdbcTemplate.update("UPDATE books SET pieces = pieces+? WHERE id = ?", pieces, id);
    }
}
