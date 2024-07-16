package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.todo.common.JDBCUtill;

import java.sql.*;

//테스트 메소드 끼리의 실행 순서를 지정해주는 어노테이션(MethodOrderer)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
//    JDBC 연결 객체를 생성하여 초기화.
    Connection conn = JDBCUtill.getConnection();

    @AfterAll
    static void tearDown() {
//        모든 테스트가 완료된 후 JDBC 연결 종료
        JDBCUtill.close();
    }

    @Test
    @DisplayName("new user enlisted.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into user(id, password, name, role) values(?,?,?,?)";

//        try를 쓰면 끝날 때 close를 쓰지 않아도 자동으로 닫힌다.
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스꼴라");
            pstmt.setString(4, "USER");

//            SQL 쿼리 실행 및 삽입된 행의 수를 반환.
            int count = pstmt.executeUpdate();
//            삽입된 행의 수가 1인지 확인하는 테스트
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user list extract")
    @Order(2)
    public void selectUser() throws SQLException {
//        모든 사용자 정보 조회 SQL쿼리
        String sql = "select * from user";
//        Select문은 executeQuery를 사용하며 return 값은 테이블이다.
        try(Statement stmt = conn.createStatement();
//            결과 집합(resultSet)에서 데이터를 읽어와 출력
//            next()로 다음 데이터가 있는지 체크해서 있을 때 까지 while문으로 반복.
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("search specific user")
    @Order(3)
    public void searchUserById() throws SQLException {
        String userid = "scoula";
        String sql = "select * from user where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
//            SQL 쿼리의 매개변수 설정
            stmt.setString(1, userid);
            try(ResultSet rs = stmt.executeQuery()) {
//                결과 집합에서 해당 데이터를 하나 읽어와 출력
//                결과가 하나기 때문에 while문이 아니라 if문으로 체크해줌.
                if(rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
//                    사용자가 존재하지 않으면 예외 발생시킴
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("update specific user")
    @Order(4)
    public void updateUser() throws SQLException {
//        수정할 사용자 id
        String userid = "scoula";

//        해당 id 사용자 이름을 수정하는 쿼리
        String sql = "update user set password = ? where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
//            SQL 쿼리 매개변수 설정
            stmt.setString(1, "스콜라수정");
            stmt.setString(2, userid);
//            SQL 쿼리 실행 및 수정된 행의 수 반환.
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("delete specific user")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
//        해당 아이디의 사용자를 삭제하는 SQL쿼리.
        String sql = "delete from user where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
