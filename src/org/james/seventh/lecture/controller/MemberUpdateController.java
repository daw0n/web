package org.james.seventh.lecture.controller;

import java.util.HashMap;
import java.util.Map;

import org.james.seventh.lecture.common.binding.DataBinding;
import org.james.seventh.lecture.common.controller.Controller;
import org.james.seventh.lecture.dao.MemberDao;
import org.james.seventh.lecture.vo.Member;

public class MemberUpdateController implements Controller, DataBinding {
	private MemberDao memberDao = null;
	
	public void setMemberDao(MemberDao memberDao) {
		// TODO Auto-generated method stub
		this.memberDao = memberDao;
	}
	@Override
	public Map<String, Class<?>> getDataBinders(){
		Map<String, Class<?>> dataBinders = new HashMap<String, Class<?>>();
		dataBinders.put("member", Member.class);
		
		return dataBinders;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String viewUrl = "";
		Member member = (Member) model.get("member");
		
		if(member.getEmail() == null) {
			Member result = memberDao.selectOne(member);
			model.put("member", result);
			
			viewUrl = "/member/MemberUpdateForm.jsp";	
		}
		else {
			memberDao.update(member);
			viewUrl = "redirect:list.do";
		}
		
		return viewUrl;
	}
}
