package org.scoula.jdbc_ex.todo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO객체 : Value Object, 특정 테이블의 한 행을 매핑하는 클래스.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
//    각각의 컬럼명과 동일.
    private String id;
    private String password;
    private String name;
    private String role;
}
