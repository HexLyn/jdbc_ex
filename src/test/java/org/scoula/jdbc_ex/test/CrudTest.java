package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtill;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtill.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtill.close();
    }
    @Test
    @DisplayName("new user enlisted.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into users(id, password, name, role) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스꼴라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user list extract")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }
}
