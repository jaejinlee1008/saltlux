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

}
