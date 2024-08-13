package edu.kh.member.service;

import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberService {

	boolean addMember(String name, String phone) throws IOException;

	List<Member> getMemberList();

	List<Member> getMemberList(String searchName);

}
