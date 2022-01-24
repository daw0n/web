package org.james.seventh.lecture.controller;

import java.util.Map;

import org.james.seventh.lecture.common.controller.Controller;
import org.james.seventh.lecture.dao.MemberDao;

public class MemberListController implements Controller{
	private MemberDao memberDao = null;

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		model.put("members", memberDao.selectList());
		
		return "/member/MemberList.jsp";
	}

	public void setMemberDao(MemberDao memberDao) {
		// TODO Auto-generated method stub
		this.memberDao = memberDao;
	}

}
