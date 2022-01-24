package org.james.seventh.lecture.controller;

import java.util.Map;

import org.james.seventh.lecture.common.controller.Controller;
import org.james.seventh.lecture.dao.MemberDao;
import org.james.seventh.lecture.vo.Member;

public class logInController implements Controller{
	private MemberDao memberDao;
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void setMemberDao(MemberDao memberDao) {
		// TODO Auto-generated method stub
		this.memberDao = memberDao;
	}
}
