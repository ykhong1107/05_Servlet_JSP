package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//주소 제일 앞에 "/" 꼭 작성!!
//-> 서블릿 매핑에서 유효하지 않은 <url-pattern> [el/scope] 오류 발생
@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet{

	// a태그 요청은 GET방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* 요청처리 */
		
		// 1. page scope -> JSP에서만 확인가능
		
		// 2. request scope
		// - 요청받은 Servlet/JSP와
		//   요청이 위임된 Servlet/JSP 에서 유지되는 객체
		
		// * Servlet/JSP 범위객체에
		// 1. 값(속성) 추가하는 방법
		// 범위객체.setAttribute("key", value);
		
		// 2. 값(속성) 얻어오는 방법
		// Object 범위객체.getAttribute("key");
		// -> 반환형 Object -> 필요시 다운캐스팅(보통 toString()을 이용하기때문에 거의안한다고하심)
		
		req.setAttribute("requestValue", "request Scope 객체에 세팅한 값");
		
		System.out.println(req.getAttribute("requestValue"));
		
		// =======================================================
		
		// 3. session(입회, 접속) scope
		// - 클라이언트가 서버에 첫 요청시
		//   서버쪽에 생성되는 객체
		
		// - 클라이언트가 브라우저를 종료하거나
		//   지정된 세션 만료시간이 지나면 사라짐
		// -> 위 상황이 아니면 계속 유지되는 객체
		
		// 1) session scope 객체 얻어오기
		HttpSession session = req.getSession();
		
		// 2) session scope 객체에 값 세팅
		session.setAttribute("sessionValue", "session scope 객체에 세팅한 값");
		
		/* session 만료시키기 */
		session.setMaxInactiveInterval(5); // 초단위
		
		// ===================================
		
		// 4. application scope
		// - 서버전체에 1개만 존재하는 객체
		// -> 모든 클라이언트가 공유
		
		// - 서버 시작시 생성, 서버 종류시 소멸
		
		// 1) application scope 객체 얻어오기
		ServletContext application = req.getServletContext();
		
		// 2) 값 세팅
		application.setAttribute("applicationValue", "application scope 객체에 세팅한 값");
		
		// ======================================
		
		// 5. 범위별 우선순위 확인
		// (좁은 범위가 우선순위가 높다!!!)
		// page > request > session > application
		
		// key 값을 동일하게하여 범위별 객체에 값 추가
		req.setAttribute		("menu", "짬뽕(request)");
		session.setAttribute	("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		
		
		
		// -----------------------------------
		
		/* 응답처리 */
		String path = "/WEB-INF/views/el/scope.jsp";
		
		//  지정된 JSP 경로로 요청을 넘겨줄
		//    요청 발송자(RequestDispatcher) 객체생성
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		
		//  요청 위임하기
		dispatcher.forward(req, resp);
		
				
				
	}
	
	
	
	
	
	
	
}
