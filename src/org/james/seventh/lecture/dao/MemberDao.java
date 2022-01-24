package org.james.seventh.lecture.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.james.seventh.lecture.vo.Member;

public interface MemberDao {
	public void setSqlSession(SqlSession sqlSession);
	public List<Member> selectList() throws Exception;
	public int insert(Member member) throws Exception;
	public int delete(int no) throws Exception;
	public Member selectOne(Member member) throws Exception;
	public int update(Member member) throws Exception;
	public Member exist(Member member) throws Exception;
}
