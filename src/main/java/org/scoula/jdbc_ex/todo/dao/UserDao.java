package org.scoula.jdbc_ex.todo.dao;

import org.scoula.jdbc_ex.todo.domain.UserVO;

// DAO클래스 : Data Access Object, db에 접근하여
// 실질적인 db연동 작업을 담당하는 클래스. 테이블에 대한 CRUD연산을 처리한다.

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//Dao에선 틀만 구현해 놓고, Imp에서 세부 데이터들을
public interface UserDao {
    // 회원 등록
    int create(UserVO user) throws SQLException;
    // 회원 목록 조회
    List<UserVO> getList() throws SQLException;

    // 회원 정보 조회
    Optional<UserVO> get(String id) throws SQLException;
    //    존재하지 않는 경우 빈 Optional 객체 반환

    // 회원 수정
    int update(UserVO user) throws SQLException;

    // 회원 삭제
    int delete(String id) throws SQLException;
// CRUD에서 보통 R은 두 개를 만든다.
}
