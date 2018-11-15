package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Emp;

// 인터페이스의 구현체 역할을 수행할 수 있는 객체(일종의 프록시)를
// 마이바티스가 빈 컨테이너에 등록합니다.
@Mapper
public interface EmpDao {
   // 리턴자료형 int: 작업결과로 영향받은 row의 개수를 의미합니다.
   public int insert(Emp emp);
   public int update(Emp emp);
   public int delete(int empno);

   public List<Emp> findAll();
   public int count();
   public Emp findOne(int empno);
   
   
   
  
   
   
   // 테이블의 특정범위의 로우들만을 조회하고 싶다
   // 전제 : 정렬은 이미 되어 있다.
   // 거의 대부분의 디비는 PK의 오름차순으로 정렬한 상태로 데이터를 유지한다.
   
   // start : empno의 시작값 , end : empno의 종료 값 
   public List<Emp> findStartEnd(int start, int end);
   
   // skip : 앞에서부터 얼마나 스킵할 것인지에 대한 값 , limit : 구하는 로우의 개수
   public List<Emp> findSkipLimit(int skip, int limit);
   
   // page : ceil(전체 로우의 개수/size) 후 구해지는 페이지 번호 , size : 구하는 로우의 개수
   /*
    * 예 :
    * 전체 로우의 개수 = 21
    * 사이즈 = 10
    * ceil(21/10) = 3 / ceil 은 소수점이 있으면 무조건 +1 
    * 
    */
   public List<Emp> findPageSize(int page, int size);
}


