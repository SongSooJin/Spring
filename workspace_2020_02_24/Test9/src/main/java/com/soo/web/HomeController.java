package com.soo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soo.web.dto.BoardDTO;
import com.soo.web.dto.LoginDTO;
import com.soo.web.service.IotService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//service와 연결
	@Autowired
	private IotService iotService;
		
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {		
		return "index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(LoginDTO dto, HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		// 객체를 만들겠습니다. = id, pw, name
		
		//System.out.println(dto.getId()); //이름이 일치하면 자동대입
		//System.out.println(dto.getPw());
		
		String name = iotService.login(dto);
		
		System.out.println(name); //있으면 이름, 없으면 null
	
		if(name != null ) {//1. 정상 로그인 될 경우 = board
			//정상적으로 로그인 되었다면 세션만들기 (쿠키(클라이언트피시에 저장)와 다르게 서버쪽에 생성)
			HttpSession session = request.getSession();
			session.setAttribute("name", name); //이름, 값
			
			mv.setViewName("redirect:board"); // 갈.jsp주소
		
		//2. 로그인 불가 = / 
		} else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView board() throws Exception {
		
		ModelAndView mv = new ModelAndView("board");
		//mv.setViewName("board"); //jsp파일명
		
		List<BoardDTO> list = iotService.list();
		mv.addObject("list", list);//이름,값
		
		//System.out.println(list);
		
		return mv;
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView("redirect:/");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") != null ) {
			
			session.removeAttribute("name"); //name만 끊기
			
		}
		
			session.invalidate();//모든 세션 끊기
		
		return mv;
	}
	
	
}


/*
 * Spring -> 전자정부 프레임워크 
 * 스프링 프레임 워크 
 * DI : 의존성 주입 = 스프링에 위임합니다. 어노테이션 표시 
 * IOC : 제어 역전 = 의존성 주입을 스프링에 위임
 * AOP : 관점지향 프로그래밍 = 해당 일이 시작해야할때 동작하는 프로그래밍
 * 
 * mvc
 * 
 * 어노테이션 - 클래스 선언부 위에 작성합니다. 
 * 
 * 객체 생성
 *
 * 1. @Controller 	: 객체 생성, Controller역할 
 * 2. @Service 		: 객체 생성, Service역할
 * 3. @Repository 	: 객체 생성, DAO역할 
 * 4. @Component 	: 객체 생성, 그외 나머지 역할 (DTO ...)
 * 
 * 객제 주입
 * 
 * 5. @Inject 		: 자바에서 제공, 데이터 타입으로 찾습니다. 
 * 6. @Autowired 	: 스프링에서 제공, 데이터 타입으로 찾기
 * 7. @Resource(name="") 	: name으로 검색
 * 
 * ==========================================================
 * 
 * 1. dispatherServlet
 * 	- web요청과 응답, Life Cycle주관
 * 
 * 2. HandlerMapping
 * 	- web요청시 해당 URL을 어떤 Controller가 처리할지 설정 -> 해당 Controller의 객체 리턴
 * 
 * 3. Controller
 * 	- 비지니스 로직을 실행하고 결과 데이터를 ModelAndView에 반영합니다. 
 *
 * 4. ModelAndView
 * 	- Controller가 수행한 결과를 반영하는 Model객체와 이동할 페이지 View객체 정보가 있습니다.
 * 
 * 5. ViewResolver
 * 	- 어떤 view를 호출할 지 결정합니다.
 * 
 * 6. View
 * 	- 결과 데이터(Model)을 출력(jsp)합니다. 
 * 
 * 
 * 
 * 
 * 
 */