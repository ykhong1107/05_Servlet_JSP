package edu.kh.member.dao;

import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberDao  {

	List<Member> getMemberList();

	boolean addMember(Member member);

}
