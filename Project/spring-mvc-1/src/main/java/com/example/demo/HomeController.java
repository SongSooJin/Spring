package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // HomeController 해당클래스 이름만 바꿔주면
																						// 쓸수 있다.
	// http://localhost:8080/mvc/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// Model model 디스팩쳐 서블릿에게 데이터 넘겨줌

		// 로그의 중요도에 따라서 분류해서 관리하고자 메소드를 다르게 사용한다.
		logger.debug("Welcome home! The client locale is {}.", locale);
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.trace("Welcome home! The client locale is {}.", locale);
		logger.warn("Welcome home! The client locale is {}.", locale);
		logger.error("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		// 모델에 담겨져 있는 데이터는 DS 에서 HttpServletRequest 객체에 옮겨진다.
		model.addAttribute("serverTime", formattedDate);

		// 컨트롤러에서 리턴하는 문자열은 뷰(화면담당파일)의 의미, home 이라는 뷰에게 포워딩한다.
		return "home"; // home 이라는 뷰에게 포워딩한다. 컨트롤러에서 리턴하는 값이 문자열이면 뷰에게 포워딩
	}

	// 요청방식을 생략하면 모든 요청방식에 대응한다.
	@RequestMapping(value = "/one", method = RequestMethod.GET)
	@ResponseBody // 리턴문자열은 뷰가 아니라 응답하는 데이터가 된다.
	public String one() {
		return "one";
	}
}
