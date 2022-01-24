package org.james.seventh.lecture.common.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.james.seventh.lecture.dao.impl.MemberDaoImpl;
import org.james.seventh.lecture.vo.Member;

// ServletContext?óê Î≥¥Í??êú MemberDao ?Ç¨?ö©?ïòÍ∏?  
@WebServlet("/auth/login")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			MemberDaoImpl memberDao = (MemberDaoImpl) sc.getAttribute("memberDao");
			Member param = new Member();
			param.setEmail(request.getParameter("email"));
			param.setPassword(request.getParameter("password"));
			
			Member member = memberDao.exist(param);
			if (member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("../member/list");

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInFail.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}
}
