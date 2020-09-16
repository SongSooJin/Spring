package com.soo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soo.web.dto.BoardDTO;
import com.soo.web.service.IotService;

@Controller
public class IotController {
	
	@Autowired
	private IotService iotService;
	
	//RequestMapping(value = "/write" , method = RequestMethod.GET)
	//@GetMapping(value = "/write")
	//@PostMapping(value = "/write")
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView write(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("write");
		//세션이 없다면  /로 이동하기
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") == null) {
			mv.setViewName("redirsect:/");
			
			
		}
		return mv;
	}
	
	@PostMapping(value = "/writeAction")
	public ModelAndView writeAction(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:board");
		
		// 사용자가 입력한 글 받아오기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//System.out.println(title);
		//System.out.println(content);
		
		//임시 login_no   name
		//int login_no = 1;
		//session에서 name 얻어오기
		HttpSession session = request.getSession();
		//session.getAttribute("name");
		//객체로 = boardDTO
		BoardDTO dto = new BoardDTO();
		dto.setBoard_title(title);
		dto.setBoard_content(content);
		dto.setLogin_name((String)session.getAttribute("name")); //String(int) 임시 사용자 번호

		//Controller -> Service -> DAO -> SqlSession -> DB
	
		iotService.writeAction(dto);
		
		return mv;
		
	}
	
	@RequestMapping(value ="detail", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO dto) throws Exception{
		ModelAndView mv = new ModelAndView("detail");
		System.out.println(dto.getBoard_no());
		
		if(dto.getBoard_no() <= 0) {
			//없다면 -> board로 다시 보내기
			mv.setViewName("redirect:board");
		}else{
			//있다면 -> DB에서 값 읽어오기 -> detail.jsp 열기
			dto = iotService.detail(dto);
//			System.out.println(dto.getBoard_no());
//			System.out.println(dto.getBoard_title());
//			System.out.println(dto.getBoard_content());
//			System.out.println(dto.getLogin_name());
			mv.addObject("dto", dto);
		}
		
		return mv;
	}
	
	
}
