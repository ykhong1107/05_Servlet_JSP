package edu.kh.member.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.member.dao.MemberDao;
import edu.kh.member.dao.MemberDaoImpl;
import edu.kh.member.dto.Member;

public class MemberServiceImpl implements MemberService{

	private MemberDao dao = null;
	
	private String[] gradeArr = {"일반", "골드", "다이아"};
	
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		dao = new MemberDaoImpl();
		
	}
	
	@Override
	public boolean addMember(String name, String phone) throws IOException {
		
		List<Member> memberList = dao.getMemberList();
		
		for(Member member : memberList) {
			
			if( phone.equals(member.getPhone())) {
				return false;
			}
			
		}
		
		Member member = new Member(name, phone, 0, Member.COMMON);
		
		boolean result = dao.addMember(member);
		
		return result;
		
	}

	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public List<Member> getMemberList(String searchName) {
		return null;
	}

}
