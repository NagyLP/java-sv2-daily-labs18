package day03;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

class PersonTest {

    PersonDao personDao;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/bookstore?useUnicode=true");
        dataSource.setUser("***");
        dataSource.setPassword("***");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

//        deleteAndCreateTable(dataSource);

        Flyway fw = Flyway.configure().dataSource(dataSource).load();
        fw.clean();
        fw.migrate();
    }

    @Test
    void testSavePerson() {

    }

//    private void deleteAndCreateTable(MariaDbDataSource dataSource) {
//        try (Conn)
//
//            stmt.exeUpdate("DROP table person");
//            stmt.exeUpdate("CREATE TABLE ");
//    }


}
