package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fr/forward")
public class FowardServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		// requestScope에 값 세팅
		req.setAttribute("str", "안녕하세요");
		
		// JSP 파일경로 작성(webapp 폴더 기준)
		String path = "/WEB-INF/views/fr/forward_result.jsp";
		
		// 요청 방송자를 이용해서 req, resp 위임하기
		req.getRequestDispatcher(path).forward(req, resp);
	
	
	}
	
	

}
