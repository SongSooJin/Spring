package com.soo.web;

import java.io.IOException;
import java.io.PrintWriter; // 파일전송 단위를 최대로 보낼수있음

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Index() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String str = "hello";
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>서블릿</h1>");
		pw.println("서블릿을 사용하고 있습니다.<br>");
		pw.println("서버에서 온 값 " + str);
		pw.println("</body>");
		pw.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
