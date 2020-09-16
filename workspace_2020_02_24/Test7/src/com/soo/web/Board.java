package com.soo.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soo.dao.BoardDAO2;
import com.soo.dto.BoardDTO;


@WebServlet("/board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Board() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//DB와 연결해서 값 받기
		BoardDAO2 dao = new BoardDAO2();
		ArrayList<BoardDTO> list = dao.list();
		//board.jsp
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("list", list);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/board.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
