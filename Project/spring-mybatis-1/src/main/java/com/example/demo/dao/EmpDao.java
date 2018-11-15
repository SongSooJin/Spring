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

   // 마이바티스가 제공하는 애노테이션으로 사용할 SQL을 설정할 수 있다.
//   @Select("select * from emp order by empno asc")
   public List<Emp> findAll();
   
//   @Select("select count(*) from emp")
   public int count();
   
   /*
    * 1. 칼럼명들 == 멤버변수명들, 마이바티스가 알아서 처리
    * 2. 칼럼명 != 멤버변수명, 마이바티스에게 매핑로직을 알려줘야 한다.
    */
//   @Select("select * from emp where empno=#{empno}")  // #{}는 표현식  파라미터가 이름이  empno거든? empno로 치환 시켜줘
   
   // #1. 생략가능, 생략하면 이 방식을 사용한다.
   // @ResultType(Emp.class) 
   
   // #2. 칼럼명과 멤버변수명이 상이할 때, 명시적으로 매핑방법을 설정한다.
//   @Results(id="empRowMapper", value={ 
//         @Result(property="empno", column="empno"),
//         @Result(property="ename", column="ename"),
//         @Result(property="job", column="job"),
//         @Result(property="sal", column="sal")
//   })
   public Emp findOne(int empno);
}


//인터페이스는 new해서 사용 할 수 없어.근데 이파일에서는 
//누군가 인터페이스의 구현체를 만들고 new해서  빈 컨테이너에 등록했어.
//그게 바로 @Mapper 이친구가 구현체를 만들고 빈 컨테이너에 등록해줬어

