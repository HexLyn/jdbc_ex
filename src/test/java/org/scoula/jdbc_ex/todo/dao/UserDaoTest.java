package org.scoula.jdbc_ex.todo.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.todo.common.JDBCUtill;
import org.scoula.jdbc_ex.todo.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//UserDao 구현체의 CRUD 작업을 테스트 하는 클래스
class UserDaoTest {
//    업캐스팅 = 다른 클래스로 갈아끼우기 쉽다.
    UserDao dao = new UserDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtill.close();
    }

    @Test
    @DisplayName("user enlist.")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO
                ("ssamz3", "ssamz123",
                        "쌤즈", "ADMIN");
        int count = dao.create(user);
        assertEquals(1, count);
    }

    @Test
    @DisplayName("UserDao User extract")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> users = dao.getList();
        for(UserVO vo : users) {
            System.out.println(vo);
        }
    }

    @Test
    @DisplayName("specific user extract")
    @Order(3)
    void get() throws SQLException {
//        특정 사용자 정보 조회
//        해당 값이 없으면 NoSuchElementException 예외 던짐.
        UserVO user = dao.get("ssamz3")
                .orElseThrow(NoSuchElementException::new);
//        조회된 사용자 값이 null이 아닌지 확인하는 테스트
        Assertions.assertNotNull(user);
    }

    @Test
    @DisplayName("update user info")
    @Order(4)
    void update() throws SQLException {
//        특정 사용자의 정보 조회하여 수정.
        UserVO user = dao.get("ssamz3")
                .orElseThrow(NoSuchElementException::new);
        user.setName("쌤즈3");
        int count = dao.update(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("delete user")
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("ssamz3");
        Assertions.assertEquals(1, count);
    }
}