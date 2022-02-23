package day03;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonDao {

    MariaDbDataSource dataSource = new MariaDbDataSource();
    JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);


    public Person findById(long id) {
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(
//                             "SELECT * FROM person" +
//                                     " WHERE id = ?;")) {
//            stmt.setLong(1, id);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if(rs.next()) {
//                    String name = rs.getString("name_of_person");
//                    LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
//                    int height = rs.getInt("height");
//                    double weight = rs.getDouble("weight");
//                    return new Person();
//                }
//            }
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Can not find Person.", sqle);
//        }
//        throw new IllegalArgumentException("No such person.");

        return jdbcTemp.queryForObject(
                "SELECT * FROM person WHERE id = ?;",
                (rs, rowNum) -> new Person(), id
        );
    }

    public Optional<List<String>> listPeopleNames() {
//        try (Connection conn = dataSource.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(
//                     "SELECT name_of_person FROM person;"
//             )) {
//            List<String> names = new ArrayList<>();
//            while (rs.next()) {
//                String name = rs.getString("name_of_person");
//                names.add(name);
//            }
//            return Optional.of(names);
//        } catch (SQLException sqle){
//        throw new IllegalStateException("Can not find person", sqle);
//        }

        return Optional.of(jdbcTemp.query(
                "SELECT name_of_person from person",
                this::mapRow));
    }


    private String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString("name_of person");
    }
}
