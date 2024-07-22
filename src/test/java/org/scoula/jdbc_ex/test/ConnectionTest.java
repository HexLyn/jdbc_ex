package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.todo.common.JDBCUtill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc db connect.")
    public void testConnection() throws SQLException, ClassNotFoundException {
//        mysql, jdbc 드라이버를 로드함
        Class.forName("com.mysql.cj.jdbc.Driver");

//        db연결을 위해 url, id, 비번 설정(준비과정).
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "jdbc_ex";
        String passward = "jdbc_ex";

//        실제로 db 연결, DriverManager를 사용해 db연결 객체 생성
        Connection conn = DriverManager.getConnection(url, id, passward);
        System.out.println("DB connection established.(성공했다는 뜻");
        conn.close();
    }
    @Test
    @DisplayName("load jdbc db. (auto)")
    public void testConnection2() throws SQLException {
        try(Connection conn = JDBCUtill.getConnection()) {
            System.out.println("DB connection established!!!");
        }
    }
}
