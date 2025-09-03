package com.sample_01.sample_01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void testDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("데이터베이스 연결 성공!");
            System.out.println("DB URL: " + connection.getMetaData().getURL());
            System.out.println("DB Username: " + connection.getMetaData().getUserName());
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결 실패!");
            e.printStackTrace();
        }
    }
}

// @ 실행스크립트
// ./mvnw test -Dtest=com.sample_01.sample_01.DatabaseConnectionTest

