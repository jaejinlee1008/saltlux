package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	public Member select(Member member) {
		// DB처리
		// MyBatis 이용
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member result = sqlSession.selectOne("myMember.login",member);
		sqlSession.close();
		return result;
	}

	public Member checkId(Member member) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Member result = sqlSession.selectOne("myMember.checkId",member);
		sqlSession.close();
		return result;
	}

	public int insertMember(Member member) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.insert("myMember.insertMember",member);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int updateMember(Member member) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.update("myMember.updateMember",member);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

	public int deleteMember(Member member) {
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int count = session.update("myMember.deleteMember",member);
		if(count==1)
		{
			session.commit();
		}
		session.close();
		return count;
	}

}
