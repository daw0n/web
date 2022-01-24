package org.james.seventh.lecture.dao.impl;

// DBConnectionPool �쟻�슜
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.james.seventh.lecture.dao.MemberDao;
import org.james.seventh.lecture.vo.Member;

public class MemberDaoImpl implements MemberDao{
	private final String PREFIX = "org.james.member.";
	private SqlSession sqlSession = null;
		
	@Override
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Member> selectList() throws Exception {
		List<Member> members = null;
		members = sqlSession.selectList(PREFIX +  "selectMembers");
		
		return members;
	}
	
	@Override
	public int insert(Member member) throws Exception {
		int result = 0;
		result = sqlSession.insert(PREFIX + "insertMemberInfo", member);
		return result;
	}
	
	@Override
	public int delete(int no) throws Exception {
		int result = 0;
		result = sqlSession.delete(PREFIX + "deleteMember", no);
		return result;
	}
	
	@Override
	public Member selectOne(Member param) throws Exception {
		Member member = null;
		member = sqlSession.selectOne(PREFIX + "selectMember", param);
		
		return member;
	}
	
	@Override
	public int update(Member member) throws Exception {
		int result = 0;
		result = sqlSession.update(PREFIX + "updateMember", member);
		return result;
	}
	
	@Override
	public Member exist(Member param) throws Exception {
		Member member = null;
		member = sqlSession.selectOne(PREFIX + "selectCheckingMember", param);
		
		return member;
	}

}
