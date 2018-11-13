drop table if exists emp;
-- emp가 있다면 삭제하세요

-- identity : 디비가 지원하는 키 생성전략을 사용한다.
-- H2는 자동으로 키 값을 제너레이트 한다.

-- emp 다시 만드세요
 create table emp (
	empno int identity not null primary key,
	ename varchar(100),
	job varchar(100),
	sal double
);