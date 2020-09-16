package com.soo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index2")
public class Index2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Index2() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
				//이제는 서블릿에서 처리하고 jsp로 값을 보내도록 하겠습니다.
				//index2.jsp
			
				HashMap<String, String> mapList = new HashMap<String, String>();
				mapList.put("1", "하나");
				mapList.put("2", "둘");
				mapList.put("3", "셋");
				mapList.put("4", "넷");
				mapList.put("5", "다섯");
				
				request.setAttribute("map", mapList);//애트리뷰트에 등록
		
		
			  ArrayList<String> list = new ArrayList<String>(); 
			  list.add("첫번째 글");
			  list.add("두번째 글"); 
			  list.add("세번째 글"); 
			  list.add("네번째 글"); 
			  list.add("다섯번째 글");
			  
			  request.setAttribute("list", list);
		 
			String str = "hello";
			request.setAttribute("ini", str); // 앞에는 이름ini로 호출하면, 뒤는 값"hello"가 나오게
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/index2.jsp");
			rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
