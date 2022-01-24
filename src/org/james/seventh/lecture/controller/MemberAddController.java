package org.james.seventh.lecture.controller;

import java.util.HashMap;
import java.util.Map;

import org.james.seventh.lecture.common.binding.DataBinding;
import org.james.seventh.lecture.common.controller.Controller;
import org.james.seventh.lecture.dao.MemberDao;
import org.james.seventh.lecture.vo.Member;

public class MemberAddController implements Controller, DataBinding{
	private MemberDao memberDao = null;
	
	public void setMemberDao(MemberDao memberDao) {
		// TODO Auto-generated method stub
		this.memberDao = memberDao;
	}
	
	@Override
	public Map<String, Class<?>> getDataBinders(){
		Map<String, Class<?>> binderMap = new HashMap<String, Class<?>>();
		
		binderMap.put("member", Member.class);
		return binderMap;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		String viewUrl = "";
		Member member = (Member) model.get("member");
		if(member.getEmail() == null) {
			viewUrl = "/member/MemberForm.jsp";
		}
		else {
			memberDao.insert(member);
			viewUrl = "redirect:list.do";
		}
		
		return viewUrl;	
	}
}
