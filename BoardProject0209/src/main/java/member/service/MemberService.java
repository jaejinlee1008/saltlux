package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인 Transaction 처리 진행
		MemberDao dao = new MemberDao();
		Member result = dao.select(member);
		return result;
	}

	public Member idcheck(Member member) {
		MemberDao dao = new MemberDao();
		Member result = dao.checkId(member);
		return result;
	}

	public int join(Member member) {
		MemberDao dao = new MemberDao();
		int count = 0;
		count = dao.insertMember(member);
		
		if(count==0)
		{
			System.out.println("회원가입 실패");
		}else if(count==1)
		{
			System.out.println("성공적으로 회원가입");
		}
		return count;
	}

	public int updateMember(Member member) {
		MemberDao dao = new MemberDao();
		int count = 0;
		count = dao.updateMember(member);
		
		if(count==0)
		{
			System.out.println("회원정보수정 실패");
		}else if(count==1)
		{
			System.out.println("성공적으로 회원정보수정");
		}
		return count;
	}

	public int deleteMember(Member member) {
		MemberDao dao = new MemberDao();
		int count = 0;
		count = dao.deleteMember(member);
		
		if(count==0)
		{
			System.out.println("회원정보수정 실패");
		}else if(count==1)
		{
			System.out.println("성공적으로 회원정보수정");
		}
		return count;
	}

}
