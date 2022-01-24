package org.james.seventh.lecture.listeners;

import java.io.InputStream;
import java.sql.SQLException;

// DBConnectionPool �쟻�슜
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.ognl.MemberAccess;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.james.seventh.lecture.controller.MemberAddController;
import org.james.seventh.lecture.controller.MemberDeleteController;
import org.james.seventh.lecture.controller.MemberListController;
import org.james.seventh.lecture.controller.MemberUpdateController;
import org.james.seventh.lecture.controller.logInController;
import org.james.seventh.lecture.controller.logOutController;
import org.james.seventh.lecture.dao.MemberDao;
import org.james.seventh.lecture.dao.impl.MemberDaoImpl;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logInController logInController = new logInController();
		logOutController logoutController = new logOutController();
		MemberListController memberListController = new MemberListController();
		MemberAddController memberAddController = new MemberAddController();
		MemberUpdateController memberUpdateController = new MemberUpdateController();
		MemberDeleteController memberDeleteController = new MemberDeleteController();
		
		try {
			ServletContext sc = event.getServletContext();
			
			InputStream is = Resources.getResourceAsStream("/config/config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			MemberDao memberDao = new MemberDaoImpl();
			memberDao.setSqlSession(sqlSession);

			sc.setAttribute("memberDao", memberDao);
			
			logInController.setMemberDao(memberDao);
			memberListController.setMemberDao(memberDao);
			memberAddController.setMemberDao(memberDao);
			memberUpdateController.setMemberDao(memberDao);
			memberDeleteController.setMemberDao(memberDao);
			
			sc.setAttribute("/auth/login.do", logInController);
			sc.setAttribute("/auth/logout.do", logoutController);
			sc.setAttribute("/member/list.do", memberListController);
			sc.setAttribute("/member/add.do", memberAddController);
			sc.setAttribute("/member/update.do", memberUpdateController);
			sc.setAttribute("/member/delete.do", memberDeleteController);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
}
