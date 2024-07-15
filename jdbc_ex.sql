use jdbc_ex;
-- users 테이블 있는 경우 삭제.
drop table if exist users;

-- users 테이블 칼럼 생성
create table users (
                       id varchar(12) not null primary key,
                       passward varchar(12) not null,
                       name varchar(30) not null,
                       role varchar(6) not null
);

-- users 테이블 실제 데이터 입력
insert into users (id, passward, name, role)
values('guest', 'guest123', '방문자', 'USER');

insert into users (id, passward, name, role)
values('admin', 'admin123', '관리자', 'ADMIN');

insert into users (id, passward, name, role)
values('member', 'member123', '일반회원', 'USER');

-- users 전체 데이터 출력
select * from users;