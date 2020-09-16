package com.soo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.soo.web.dto.BoardDTO;
import com.soo.web.dto.CommentDTO;
import com.soo.web.service.IotService;
import com.soo.web.util.Util;

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
	
	/* 아래의 두 문구는 같은 요청방법 */
	/* @RequestMapping(value = "/writeAction", method = RequestMethod.POST) */
	@PostMapping(value = "/writeAction")
	public ModelAndView writeAction(HttpServletRequest request, MultipartFile file) throws Exception {
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
	
		//file 오는지 확인
		//System.out.println("파일 이름 : " + file.getOriginalFilename());
		//System.out.println("파일 사이즈 : " + file.getSize());
		
		
		iotService.writeAction(dto, file);
		
		return mv;
		
	}
	
	/* @RequestMapping(value ="detail", method = RequestMethod.GET) */
	@GetMapping(value = "detail")
	public ModelAndView detail(BoardDTO dto) throws Exception{
		ModelAndView mv = new ModelAndView("detail");
		//System.out.println(dto.getBoard_no());
		
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
			System.out.println("댓글수 : " + dto.getComment());
			
			if(dto.getComment() > 0) {
				//DB에서 가져와
				List<CommentDTO> comment = iotService.commentList(dto.getBoard_no());
//				System.out.println(comment.get(0).getCno());
//				System.out.println(comment.get(0).getLogin_name());
//				System.out.println(comment.get(0).getComment());
//				System.out.println(comment.get(0).getBoard_no());
				mv.addObject("comment", comment);
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "delete") // delete?board_no=25
	public String delete(HttpServletRequest request) throws Exception {
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("redirect:board");
		
		//System.out.println(request.getParameter("board_no"));
		//DB로 보내서 글 삭제하기
		//글 번호, name
		
		//번호만 받아오기 위해서 정의
		String board_no = request.getParameter("board_no");
		
		//int bno  = Integer.parseInt(board_no);
		
		//세션 불러오기
		HttpSession session = request.getSession();
		
		//세션이 있고, borad_no가 있는 경우만 실행
		BoardDTO dto = new BoardDTO();
		if(session.getAttribute("name") != null && !board_no.equals(null)) { 
			dto.setBoard_no(Util.str2Int(board_no));
			dto.setLogin_name((String)session.getAttribute("name"));
			
			iotService.delete(dto);
		}
		//return mv;
		return "redirect:board";
	} 
	
	@RequestMapping(value = "update")
	public ModelAndView update(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("update");
		//System.out.println(request.getParameter("board_no"));
		String board_no = request.getParameter("board_no");
		
		HttpSession session = request.getSession();

		//if문
		//board_no있어야 하고, session name값 있어야 통과
		//파라미터 값  dto를 만들어야 합니다.
		if(session.getAttribute("name") != null && !board_no.equals(null)) {
			
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(Util.str2Int(request.getParameter("board_no")));
			dto.setLogin_name((String)session.getAttribute("name"));
			//detail과같다
			BoardDTO update = iotService.update(dto);
			mv.addObject("update", update);
			
			System.out.println(update.getBoard_title());
		}
		
		return mv;
	}
	/*update
	 * 1.메소드 만들기 = post
	 * 2.if = 파라미터 오는지 확인 / 세션확인
	 * 3.DTO만들기 / 데이터 저장
	 * 4.DB만들기
	 * 5.board로 돌아가기
	 * */
	
	@PostMapping(value = "/updateAction")
	public String updateAction(HttpServletRequest request) throws Exception {
		
//		System.out.println(request.getParameter("title"));
//		System.out.println(request.getParameter("content"));
//		System.out.println(request.getParameter("board_no"));

		//세션객체 만들기
		HttpSession session = request.getSession();

		if(request.getParameter("title") != null && 
				request.getParameter("content")  != null &&
				request.getParameter("board_no") != null && 
				session.getAttribute("name") != null ) {
					
			String board_title = request.getParameter("title");
			String board_content = request.getParameter("content");
			String board_no = request.getParameter("board_no");
			
			BoardDTO dto = new BoardDTO();
			dto.setBoard_title(board_title);
			dto.setBoard_content(board_content);
			dto.setBoard_no(Util.str2Int(board_no));
			dto.setLogin_name((String) session.getAttribute("name"));
			
		
			//DB로 보내기
			iotService.updateAction(dto);
			//모든 처리를 마치고 해당 글로 돌아가기
			return "redirect:detail?board_no=" + dto.getBoard_no();//페이지 이동
			
		} else {
		
			return "redirect:board";
		}
	}
	
	//1. 맵핑 해주세요. comment
	@PostMapping(value = "comment")
	public String comment(HttpServletRequest request) throws Exception{		
		//2. board_no, comment, session.name = if
		HttpSession session = request.getSession();
		if(session.getAttribute("name") == null) {
			return "redirect:/";
		} else {			
			if(request.getParameter("board_no") != null 
					&& request.getParameter("comment") != null
					&& session.getAttribute("name") != null) {
				//3. 찍어주시기 = s -> dao -> db			
				String comment = request.getParameter("comment");
				int board_no = Util.str2Int(request.getParameter("board_no"));
				
//				System.out.println("board_no : " + board_no);
//				System.out.println("comment : " + comment);
//				System.out.println("name : " + session.getAttribute("name"));
				
				//4.데이터베이스로 보내기
				CommentDTO dto = new CommentDTO();
				dto.setBoard_no(board_no);
				dto.setComment(comment);
				dto.setLogin_name((String)session.getAttribute("name"));
				
				int result = iotService.comment(dto);
				System.out.println("결과 : " + result);
				
				//5.다시 자신의 글로 돌아가기
				return "redirect:detail?board_no=" + board_no;
			}else {
				return "redirect:board";
			}
		}
	}
	
		@RequestMapping(value = "del") 
		public String commentDelete(HttpServletRequest request) throws Exception {
					
		HttpSession session = request.getSession();
	
		
		if(request.getParameter("cno") != null 
				&& session.getAttribute("name") != null) {
			
			CommentDTO dto = new CommentDTO();
			dto.setCno(Util.str2Int(request.getParameter("cno")));
			dto.setLogin_name((String)session.getAttribute("name"));
			
			iotService.commentDelete(dto);
			
		
		}
		
		return "redirect:detail?board_no=" + request.getParameter("board_no");
	
	
	}
		
	
	@RequestMapping(value = "edit")
	public ModelAndView commentEdit(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("commentEdit");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") != null && 
				request.getParameter("board_no") != null && 
				request.getParameter("cno") != null) {
			
			CommentDTO edit = new CommentDTO();
			edit.setCno(Util.str2Int(request.getParameter("cno")));
			edit.setBoard_no(Util.str2Int(request.getParameter("board_no")));
			edit.setLogin_name((String)session.getAttribute("name"));
			
			CommentDTO dto = iotService.commentEdit(edit);
			String line = System.getProperty("line.separator");
			dto.setComment(dto.getComment().replaceAll("<br>", line));
			mv.addObject("dto", dto);
			
		} else {
			mv.setViewName("error");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "commentEditAction")
	public String commentEditAction(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name") != null && 
				request.getParameter("board_no") != null && 
				request.getParameter("cno") != null) {
			CommentDTO dto = new CommentDTO();
			
			dto.setBoard_no(Util.str2Int(request.getParameter("board_no")));
			dto.setCno(Util.str2Int(request.getParameter("cno")));
			dto.setLogin_name((String)session.getAttribute("name"));
			
			String comment = request.getParameter("comment");
			comment = comment.replace("<", "&lt;");
			comment = comment.replace(">", "&gt;");
			
			String line = System.getProperty("line.separator");
			comment = comment.replace(line, "<br>");//마지막
			//dto.setComment(dto.getComment().replaceAll("<br>", line));
			dto.setComment(comment);
			
			int result = iotService.commentEditAction(dto);
			
			if(result == 1) {
				System.out.println("수정성공");
				
			} else {
				System.out.println("오류발생");
			}
			
			return "redirect:detail?board_no="+request.getParameter("board_no");
		}else {
			return "redirect:error?code=comment";
		}
	
	}
	
	
	
	
}
