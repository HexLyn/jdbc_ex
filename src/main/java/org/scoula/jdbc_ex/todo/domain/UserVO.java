package org.scoula.jdbc_ex.todo.domain;

import java.util.Objects;

public class UserVO {
    // 각각의 컬럼명과 동일한 필드
    private String id;
    private String password;
    private String name;
    private String role;

    // 기본 생성자
    public UserVO() {
    }

    // 모든 필드를 받는 생성자
    public UserVO(String id, String password, String name, String role) {
        // alt + insert로 getter setter 생성.
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) &&
                Objects.equals(password, userVO.password) &&
                Objects.equals(name, userVO.name) &&
                Objects.equals(role, userVO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, name, role);
    }

    // toString method
    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // Builder class for creating UserVO instances
    public static class UserVOBuilder {
        private String id;
        private String password;
        private String name;
        private String role;

        public UserVOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserVOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserVOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserVOBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserVO build() {
            return new UserVO(id, password, name, role);
        }
    }

    public static UserVOBuilder builder() {
        return new UserVOBuilder();
    }
}
